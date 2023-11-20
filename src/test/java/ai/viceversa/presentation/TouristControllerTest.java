package ai.viceversa.presentation;

import ai.viceversa.application.ports.TouristServicePort;
import ai.viceversa.domain.model.TouristInformation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TouristServicePort touristService;

    @Test
    void getTouristInformation() throws Exception {
        // Given
        Pageable pageable = PageRequest.of(0, 10);
        List<TouristInformation> touristInformationList = new ArrayList<>();
        touristInformationList.add(new TouristInformation());
        Page<TouristInformation> mockPage = new PageImpl<>(touristInformationList);

        // When
        when(touristService.find("서울", pageable)).thenReturn(mockPage);

        // Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tourist/search")
                .param("keyword", "서울")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())  // Print response for debugging
                .andReturn();
    }
}
