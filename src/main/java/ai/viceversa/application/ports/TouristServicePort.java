package ai.viceversa.application.ports;

import ai.viceversa.domain.model.TouristInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TouristServicePort {
    Page<TouristInformation> find(String keyword, Pageable pageable);
}
