package org.stadium.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public MediaDto setId(final Integer id) {
        super.setId(id);
        return this;
    }
}
