package ai.viceversa.infrastructure.persistence;

import ai.viceversa.domain.model.TouristInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristInformationJpaRepository extends JpaRepository<TouristInformation, String> {
    Page<TouristInformation> findByGalSearchKeywordContains(String keyword, Pageable pageable);
}
