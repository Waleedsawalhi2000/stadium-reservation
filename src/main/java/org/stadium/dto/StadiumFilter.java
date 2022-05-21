package org.stadium.dto;


import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StadiumFilter {
    private String name;
    private String location;
    private Integer minPrice;
    private Integer maxPrice;
    private Timestamp minDate;
    private String maxDate;
}
