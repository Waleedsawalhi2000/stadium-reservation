package org.stadium.mapper;


import org.stadium.dto.StadiumDto;
import org.stadium.entity.Stadium;
import org.stadium.entity.User;

import java.util.stream.Collectors;

public class StadiumMapper extends AbstractMapper<Stadium, StadiumDto> {
    private final RequestMapper requestMapper = new RequestMapper();
    private final UserMapper userMapper = new UserMapper();
    private final LocationMapper locationMapper = new LocationMapper();
    private final MediaMapper mediaMapper = new MediaMapper();

    @Override
    public Stadium toEntity(final StadiumDto stadiumDto) {
        return stadiumDto == null ? null : Stadium
                .builder()
                .id(stadiumDto.getId())
                .image(mediaMapper.toEntity(stadiumDto.getImage()))
                .stadiumId(stadiumDto.getStadiumId())
                .price(stadiumDto.getPrice())
                .name(stadiumDto.getName())
                .location(locationMapper.toEntity(stadiumDto.getLocation()))
                .size(stadiumDto.getSize())
                .admin(userMapper.toEntity(stadiumDto.getAdmin()))
                .requests(requestMapper.toEntities(stadiumDto.getRequests()))
                .phoneNumber(stadiumDto.getPhoneNumber())
//                .admin(userMapper.toEntity(stadiumDto.getAdmin()))
                .description(stadiumDto.getDescription())
                .build();
    }

    @Override
    public StadiumDto toDto(final Stadium stadium) {
        return stadium == null ? null : StadiumDto
                .builder()
                .id(stadium.getId())
                .image(mediaMapper.toDto(stadium.getImage()))
                .price(stadium.getPrice())
                .name(stadium.getName())
                .stadiumId(stadium.getStadiumId())
                .location(locationMapper.toDto(stadium.getLocation()))
                .size(stadium.getSize())
                .admin(userMapper.toDto(stadium.getAdmin().setStadiums(null).setRequests(null)))
                .phoneNumber(stadium.getPhoneNumber())
                .description(stadium.getDescription())
                .build();
    }
}
