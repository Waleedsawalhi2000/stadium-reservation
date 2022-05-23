package org.stadium.mapper;

import org.stadium.entity.User;
import org.stadium.dto.UserDto;

public class UserMapper extends AbstractMapper<User, UserDto> {
    @Override
    public User toEntity(final UserDto userDto) {
        return userDto == null ? null : User
                .builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .active(userDto.getActive())
                .roles(userDto.getRoles())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .verified(userDto.getVerified())
                .userId(userDto.getUserId())
                .stadiums(new StadiumMapper().toEntities(userDto.getStadiums()))
                .requests(new RequestMapper().toEntities(userDto.getRequests()))
                .build();
    }

    @Override
    public UserDto toDto(final User user) {
        return user == null ? null : UserDto
                .builder()
                .id(user.getId())
                .userId(user.getUserId())
                .active(user.getActive())
                .username(user.getUsername())
                .roles(user.getRoles())
                .password(user.getPassword())
                .email(user.getEmail())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .phoneNumber(user.getPhoneNumber())
                .verified(user.getVerified())
                .stadiums(new StadiumMapper().toDtos(user.getStadiums()))
                .requests(new RequestMapper().toDtos(user.getRequests()))
                .build();
    }
}
