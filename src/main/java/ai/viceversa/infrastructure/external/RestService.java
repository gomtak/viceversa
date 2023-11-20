package ai.viceversa.infrastructure.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@Service
public class RestService {

    public Map call(String url, HttpMethod httpMethod, Map<String, String> headersMap, String body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headersMap.forEach(headers::set);
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response =
                restTemplate.exchange(url, httpMethod, requestEntity, String.class);
        HttpStatusCode httpStatusCode = response.getStatusCode();
        if (httpStatusCode.is2xxSuccessful()) {
            return getBody(response.getBody());
        } else {
            throw new RuntimeException("JwPlayer API Error : " + response.getBody());
        }
    }

    private Map getBody(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = null;
        try {
            map = objectMapper.readValue(response, Map.class);
            return (Map) map.get("response");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
