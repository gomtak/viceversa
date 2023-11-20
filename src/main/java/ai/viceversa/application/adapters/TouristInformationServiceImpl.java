package ai.viceversa.application.adapters;

import ai.viceversa.application.ports.TouristInformationServicePort;
import ai.viceversa.infrastructure.external.RestService;
import ai.viceversa.domain.vo.Arrange;
import ai.viceversa.domain.vo.MobileOs;
import ai.viceversa.domain.model.TouristInformation;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TouristInformationServiceImpl implements TouristInformationServicePort {
    private final RestService restService;
    @Value("${openapi.endpoint}")
    private String url;
    @Value("${openapi.service-key}")
    private String serviceKey;
    private final String type = "json";
    private final String mobileApp = "viceversa";
    @Override
    public List<TouristInformation> getTouristInformation(int numOfRows, int pageNo, MobileOs mobileOs, Arrange arrange) {
        String params = "/galleryList1?serviceKey=" + serviceKey + "&numOfRows=" + numOfRows + "&pageNo=" + pageNo + "&MobileOS=" + mobileOs + "&MobileApp=" + mobileApp + "&arrange=" + arrange + "&_type=" + type;
        Map map = new HashMap();
        map.put("acccept", "*/*");
        Map call = restService.call(url + params, HttpMethod.GET, map, null);
        Map body = (Map) call.get("body");
        Map items = (Map) body.get("items");
        List<Map> item = (List<Map>) items.get("item");
        List<TouristInformation> collect = item.stream()
                .map(this::convertToTouristInfo)
                .collect(Collectors.toList());
        return collect;
    }

    private <R> TouristInformation convertToTouristInfo(Map map) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(map, TouristInformation.class);
    }
}
