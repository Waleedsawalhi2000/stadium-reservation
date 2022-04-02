package org.car.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
    private String userId;
    private String phoneNumber;
    private String firstname;
    private String lastname;
}
