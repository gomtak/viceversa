package ai.viceversa.application.adapters;

import ai.viceversa.application.ports.TouristServicePort;
import ai.viceversa.domain.model.TouristInformation;
import ai.viceversa.domain.repository.TouristInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TouristServiceImpl implements TouristServicePort {
    private final TouristInformationRepository touristInformationRepository;
    @Override
    public Page<TouristInformation> find(String keyword, Pageable pageable) {
        return touristInformationRepository.findKeywordLike(keyword, pageable);
    }
}
