package org.stadium.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<ENTITY, DTO> {
    public abstract ENTITY toEntity(final DTO dto);

    public abstract DTO toDto(final ENTITY entity);

    public List<DTO> toDtos(final List<ENTITY> entities) {
        return entities == null ? null : entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<ENTITY> toEntities(final List<DTO> dtos) {
        return dtos == null ? null : dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
