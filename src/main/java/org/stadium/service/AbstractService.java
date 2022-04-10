package org.stadium.service;


import org.stadium.dto.BaseDto;
import org.stadium.entity.BaseEntity;
import org.stadium.mapper.AbstractMapper;
import org.stadium.repository.AbstractJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class AbstractService<ENTITY extends BaseEntity<ID>, DTO extends BaseDto<ID>, ID extends Serializable> {
    protected AbstractMapper<ENTITY, DTO> mapper;
    protected AbstractJpaRepository<ENTITY, ID> repository;

    public AbstractService(final AbstractMapper<ENTITY, DTO> mapper, final AbstractJpaRepository<ENTITY, ID> repository) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DTO> findAll() {
        return mapper.toDtos(repository.findAll());
    }

    public Page<DTO> findAll(final Pageable pageable) {
        final Page<ENTITY> page = repository.findAll(pageable);
        return new PageImpl<>(mapper.toDtos(page.getContent()), page.getPageable(), page.getTotalElements());
    }

    public DTO findById(final ID id) {
        return mapper.toDto(repository.findById(id).get());
    }

    public ENTITY create(final DTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public ENTITY update(final DTO dto, final ID id) {
        final ENTITY entity = repository.findById(id).get();
        dto.setId(entity.getId());
        return repository.save(mapper.toEntity(dto));
    }

    public Boolean delete(final ID id) {
        repository.deleteById(id);
        return true;
    }
}
