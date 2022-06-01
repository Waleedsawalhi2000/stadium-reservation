package org.stadium.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LocationDto extends BaseDto<Integer> {
    private String name;
    private String city;
    private String street;


    public LocationDto setId(final Integer id) {
        super.setId(null);
        return this;
    }
}
