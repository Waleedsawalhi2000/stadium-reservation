package org.stadium.mapper;

import org.stadium.dto.LocationDto;
import org.stadium.entity.Location;

public class LocationMapper extends AbstractMapper<Location, LocationDto> {
    @Override
    public Location toEntity(final LocationDto locationDto) {
        return locationDto == null ? null : Location
                .builder()
                .id(locationDto.getId())
                .city(locationDto.getCity())
                .name(locationDto.getName())
                .street(locationDto.getStreet())
                .build();
    }

    @Override
    public LocationDto toDto(final Location location) {
        return location == null ? null : LocationDto
                .builder()
                .id(location.getId())
                .city(location.getCity())
                .street(location.getStreet())
                .name(location.getName())
                .build();
    }
}
