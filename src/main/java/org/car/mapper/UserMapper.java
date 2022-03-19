package org.car.mapper;

import org.car.entity.User;
import org.car.entity.UserDto;

public class UserMapper extends AbstractMapper<User, UserDto> {
    @Override
    public User toEntity(final UserDto userDto) {
        return User
                .builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .active(userDto.isActive())
                .roles(userDto.getRoles())
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
                .build();
    }
}
