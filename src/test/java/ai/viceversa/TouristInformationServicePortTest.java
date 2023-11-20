package ai.viceversa;

import ai.viceversa.application.ports.TouristInformationServicePort;
import ai.viceversa.domain.vo.Arrange;
import ai.viceversa.domain.vo.MobileOs;
import ai.viceversa.domain.model.TouristInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TouristInformationServicePortTest {

    @Autowired
    private TouristInformationServicePort touristInformationServicePort;
    @Test
    void getTouristInformation() {
        List<TouristInformation> touristInformation = touristInformationServicePort.getTouristInformation(10, 1, MobileOs.ETC, Arrange.A);
        System.out.println(touristInformation.toString());
    }
}
