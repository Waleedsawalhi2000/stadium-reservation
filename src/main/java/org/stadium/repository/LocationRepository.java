package org.stadium.repository;

import org.springframework.stereotype.Repository;
import org.stadium.dto.LocationDto;
import org.stadium.entity.Location;

@Repository
public interface LocationRepository extends AbstractJpaRepository<Location, Integer> {
}
