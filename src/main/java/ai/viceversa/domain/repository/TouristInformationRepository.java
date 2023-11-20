package ai.viceversa.domain.repository;

import ai.viceversa.domain.model.TouristInformation;

import java.util.List;

public interface TouristInformationRepository {
    int saveAll(List<TouristInformation> touristInformation);

    List<TouristInformation> findAll();

    long count();
}
