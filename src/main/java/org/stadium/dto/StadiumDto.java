package org.stadium.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder
public class StadiumDto extends BaseDto<Integer> {
    private String name;
    private LocationDto location;
    private Integer price;
    private String size;
    private MediaDto image;
    private UserDto admin;
    private String stadiumId;
    @JsonIgnore
    private List<RequestDto> requests;
    private String phoneNumber;
    private String description;
}
