package ai.viceversa.infrastructure.persistence;

import ai.viceversa.domain.repository.TouristInformationRepository;
import ai.viceversa.domain.model.TouristInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TouristInformationRepositoryImpl implements TouristInformationRepository {

    private final JdbcTemplate jdbcTemplate;
    private final TouristInformationJpaRepository touristInformationJpaRepository;

    @Override
    @Transactional
    public int saveAll(List<TouristInformation> touristInformation) {
        String sql = "INSERT INTO tourist_information (gal_content_id, gal_content_type_id, gal_title, gal_web_image_url, gal_createdtime, gal_modifiedtime, gal_photography_month, gal_photography_location, gal_photographer, gal_search_keyword) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int[][] ints = jdbcTemplate.batchUpdate(sql, touristInformation, 50, (ps, argument) -> {
            ps.setString(1, argument.getGalContentId());
            ps.setString(2, argument.getGalContentTypeId());
            ps.setString(3, argument.getGalTitle());
            ps.setString(4, argument.getGalWebImageUrl());
            ps.setString(5, argument.getGalCreatedtime());
            ps.setString(6, argument.getGalModifiedtime());
            ps.setString(7, argument.getGalPhotographyMonth());
            ps.setString(8, argument.getGalPhotographyLocation());
            ps.setString(9, argument.getGalPhotographer());
            ps.setString(10, argument.getGalSearchKeyword());
        });
        return ints[0].length;
    }

    @Override
    public List<TouristInformation> findAll() {
        return touristInformationJpaRepository.findAll();
    }

    @Override
    public long count() {
        return touristInformationJpaRepository.count();
    }
}
