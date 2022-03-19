package org.car.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.car.dto.BaseDto;

@Data
@SuperBuilder
public class UserDto extends BaseDto<Integer> {
    private String email;
    private String username;
    private String password;
    private boolean active;
    private String roles;
}
