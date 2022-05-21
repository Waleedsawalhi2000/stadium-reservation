package org.stadium.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

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
    private String phoneNumber;
    private String firstname;
    private String lastname;
    private Boolean verified;
    private List<StadiumDto> stadiums;
    private List<OrderDto> orders;
}
