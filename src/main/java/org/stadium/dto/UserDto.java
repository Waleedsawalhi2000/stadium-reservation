package org.stadium.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@SuperBuilder
public class UserDto extends BaseDto<Integer> {
    private String email;
    private String username;
    private String password;
    private String userId;
    private Boolean active;
    private String roles;
    private String phoneNumber;
    private String firstname;
    private String lastname;
    private Boolean verified;
    @JsonIgnore
    private List<StadiumDto> stadiums;
    @JsonIgnore
    private List<RequestDto> requests;
}
