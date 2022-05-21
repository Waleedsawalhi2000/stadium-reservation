package org.stadium.mapper;


import org.stadium.dto.StadiumDto;
import org.stadium.entity.Stadium;

public class StadiumMapper extends AbstractMapper<Stadium, StadiumDto> {
    @Override
    public Stadium toEntity(final StadiumDto stadiumDto) {
        return Stadium
                .builder()
                .id(stadiumDto.getId())
                .image(new MediaMapper().toEntity(stadiumDto.getImage()))
                .price(stadiumDto.getPrice())
                .name(stadiumDto.getName())
                .location(new LocationMapper().toEntity(stadiumDto.getLocation()))
                .size(stadiumDto.getSize())
                .admin(new UserMapper().toEntity(stadiumDto.getAdmin()))
                .build();
    }

    @Override
    public StadiumDto toDto(final Stadium stadium) {
        return StadiumDto
                .builder()
                .id(stadium.getId())
                .image(new MediaMapper().toDto(stadium.getImage()))
                .price(stadium.getPrice())
                .name(stadium.getName())
                .location(new LocationMapper().toDto(stadium.getLocation()))
                .size(stadium.getSize())
                .admin(new UserMapper().toDto(stadium.getAdmin()))
                .build();
    }
}
