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
public class OrderDto extends BaseDto<Integer> {
    private UserDto user;
    private StadiumDto stadium;
    private Timestamp started;
    private Timestamp ended;
    private Integer totalPrice;
    private PaymentMethod paymentMethod;
}
