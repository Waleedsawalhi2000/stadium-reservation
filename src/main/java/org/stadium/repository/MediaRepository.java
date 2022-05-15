package org.stadium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.entity.Media;

import java.util.Optional;

@Repository
public interface MediaRepository extends AbstractJpaRepository<Media, Integer> {
    @Query("SELECT m FROM Media AS m WHERE m.name = :name")
    Media findMediaByName(@Param("name") final String name);
}
