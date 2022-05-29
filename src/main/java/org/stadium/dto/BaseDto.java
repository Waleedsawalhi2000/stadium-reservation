package org.stadium.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto<ID extends Serializable> {
    private ID id;

    public BaseDto setId(final ID id) {
        this.id = id;
        return this;
    }
}
