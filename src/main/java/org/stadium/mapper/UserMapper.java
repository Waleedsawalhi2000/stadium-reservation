package org.stadium.mapper;

import org.stadium.entity.User;
import org.stadium.dto.UserDto;

public class UserMapper extends AbstractMapper<User, UserDto> {
    @Override
    public User toEntity(final UserDto userDto) {
        return User
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
                .stadiums(new StadiumMapper().toEntities(userDto.getStadiums()))
                .build();
    }

    @Override
    public UserDto toDto(final User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .active(user.isActive())
                .username(user.getUsername())
                .roles(user.getRoles())
                .password(user.getPassword())
                .email(user.getEmail())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .phoneNumber(user.getPhoneNumber())
                .verified(user.getVerified())
                .stadiums(new StadiumMapper().toDtos(user.getStadiums()))
                .build();
    }
}
