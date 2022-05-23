package org.stadium.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StadiumDto extends BaseDto<Integer> {
    private String name;
    private LocationDto location;
    private Integer price;
    private String size;
    private MediaDto image;
    private UserDto admin;
    private String stadiumId;
    private List<RequestDto> requests;
}
