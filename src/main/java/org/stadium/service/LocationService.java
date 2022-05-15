package org.stadium.service;

import org.springframework.stereotype.Service;
import org.stadium.dto.LocationDto;
import org.stadium.entity.Location;
import org.stadium.mapper.AbstractMapper;
import org.stadium.mapper.LocationMapper;
import org.stadium.repository.LocationRepository;

@Service
public class LocationService extends AbstractService<Location, LocationDto, Integer> {

    public LocationService(final LocationRepository repository) {
        super(new LocationMapper(), repository);
    }
}
