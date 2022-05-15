package org.stadium.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class EmailDto {
    private String to;
    private String subject;
    private String text;
}
