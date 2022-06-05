package org.stadium.dto;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder
public class RequestDto extends BaseDto<Integer> {
    private UserDto user;
    private StadiumDto stadium;
    private LocalDate date;
    @Min(value = 0, message = "This value must between 0 and 23")
    @Max(value = 23, message = "This value must between 0 and 23")
    private Integer started;
    @Min(value = 0, message = "This value must between 0 and 23")
    @Max(value = 23, message = "This value must between 0 and 23")
    private Integer ended;
    private Integer totalPrice;
    private String paymentMethod;
    private String status;


    public Integer getStarted() {
        if (started >= 0 && started <= 23) {
            return started;
        }
        throw new IllegalStateException("This value isn't accepted");
    }
}
