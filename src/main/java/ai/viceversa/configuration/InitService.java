package ai.viceversa.configuration;

import ai.viceversa.application.ports.TouristInformationServicePort;
import ai.viceversa.domain.vo.Arrange;
import ai.viceversa.domain.repository.TouristInformationRepository;
import ai.viceversa.domain.vo.MobileOs;
import ai.viceversa.domain.model.TouristInformation;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitService {

    private final TouristInformationServicePort touristInformationServicePort;
    private final TouristInformationRepository touristInformationRepository;

    @PostConstruct
    public void init() {
        long count = touristInformationRepository.count();
        if(count != 50) {
            List<TouristInformation> touristInformation = new ArrayList<>();
            touristInformation.addAll(touristInformationServicePort.getTouristInformation(10, 1, MobileOs.ETC, Arrange.A));
            touristInformation.addAll(touristInformationServicePort.getTouristInformation(10,2,MobileOs.ETC, Arrange.A));
            touristInformation.addAll(touristInformationServicePort.getTouristInformation(10,3,MobileOs.ETC, Arrange.A));
            touristInformation.addAll(touristInformationServicePort.getTouristInformation(10,4,MobileOs.ETC, Arrange.A));
            touristInformation.addAll(touristInformationServicePort.getTouristInformation(10,5,MobileOs.ETC, Arrange.A));

            int result = touristInformationRepository.saveAll(touristInformation);
            System.out.println("Init service save result: " + result);
        }
    }
}
