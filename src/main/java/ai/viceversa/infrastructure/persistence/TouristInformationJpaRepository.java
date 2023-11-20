package ai.viceversa.infrastructure.persistence;

import ai.viceversa.domain.model.TouristInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristInformationJpaRepository extends JpaRepository<TouristInformation, String> {
}
