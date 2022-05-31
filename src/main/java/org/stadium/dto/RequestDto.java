package org.stadium.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RequestDto extends BaseDto<Integer> {
    private UserDto user;
    private StadiumDto stadium;
    private String started;
    private String ended;
    private Integer totalPrice;
    private String paymentMethod;
    private String status;
}
