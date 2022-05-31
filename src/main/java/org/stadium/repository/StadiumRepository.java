package org.stadium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stadium.dto.StadiumFilter;
import org.stadium.entity.Stadium;

import java.util.List;

@Repository
public interface StadiumRepository extends AbstractJpaRepository<Stadium, Integer> {
    @Query("SELECT s FROM Stadium AS s" +
            " WHERE (((:location IS NULL ) OR (lower(s.location.name) like concat('%', lower(:location),'%')))" +
            " OR ((:location IS NULL ) OR (lower(s.location.city) like concat('%', lower(:location),'%')))" +
            " OR ((:location IS NULL ) OR (lower(s.location.street) like concat('%', lower(:location),'%'))))" +
            " AND ((:name IS NULL ) OR (lower(s.name) like concat('%', lower(:name),'%')))" +
            " AND (s.price between :minPrice AND :maxPrice) ")
    List<Stadium> findAll(@Param("location") final String location,
                          @Param("minPrice") final Integer minPrice,
                          @Param("maxPrice") final Integer maxPrice,
                          @Param("name") final String name);
}