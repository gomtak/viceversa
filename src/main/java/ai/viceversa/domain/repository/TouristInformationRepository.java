package ai.viceversa.domain.repository;

import ai.viceversa.domain.model.TouristInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TouristInformationRepository {
    int saveAll(List<TouristInformation> touristInformation);

    List<TouristInformation> findAll();

    long count();

    Page<TouristInformation> findKeywordLike(String keyword, Pageable pageable);
}
