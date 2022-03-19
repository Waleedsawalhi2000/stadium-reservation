package org.car.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@SuperBuilder
@MappedSuperclass
public class BaseDto<ID extends Serializable> {
    private ID id;
}
