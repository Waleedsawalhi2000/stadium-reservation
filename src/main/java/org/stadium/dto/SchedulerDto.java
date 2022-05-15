package org.stadium.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SchedulerDto extends BaseDto<Integer>  {
    private Integer value;
    private UserDto userDto;
    private Timestamp timestamp;
}
