package org.car.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.car.dto.BaseDto;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
public class UserDto extends BaseDto<Integer> {
    private String email;
    private String username;
    private String password;
    private Boolean active;
    private String roles;
}
