package org.stadium.mapper;

import org.stadium.dto.LocationDto;
import org.stadium.entity.Location;

public class LocationMapper extends AbstractMapper<Location, LocationDto> {
    @Override
    public Location toEntity(final LocationDto locationDto) {
        return Location
                .builder()
                .city(locationDto.getCity())
                .name(locationDto.getName())
                .street(locationDto.getStreet())
                .build();
    }

    @Override
    public LocationDto toDto(final Location location) {
        return LocationDto
                .builder()
                .city(location.getCity())
                .street(location.getStreet())
                .name(location.getName())
                .build();
    }
}
