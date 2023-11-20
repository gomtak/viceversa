package ai.viceversa.application.ports;

import ai.viceversa.domain.model.TouristInformation;
import ai.viceversa.domain.vo.Arrange;
import ai.viceversa.domain.vo.MobileOs;

import java.util.List;

public interface TouristInformationServicePort {
    List<TouristInformation> getTouristInformation(int numOfRows, int pageNo, MobileOs mobileOs, Arrange arrange);
}
