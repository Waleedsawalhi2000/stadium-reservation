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
public class MediaDto extends BaseDto<Integer> {
    private Byte[] image;
    private String name;
    private String uri;
}
