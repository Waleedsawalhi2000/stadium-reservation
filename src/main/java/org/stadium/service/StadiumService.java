package org.stadium.service;

import org.springframework.stereotype.Service;
import org.stadium.dto.StadiumDto;
import org.stadium.entity.Stadium;
import org.stadium.mapper.StadiumMapper;
import org.stadium.repository.StadiumRepository;

import java.util.List;

@Service
public class StadiumService extends AbstractService<Stadium, StadiumDto, Integer> {
    private final StadiumRepository repository;


    public StadiumService(final StadiumRepository repository) {
        super(new StadiumMapper(), repository);
        this.repository = repository;
    }

    public List<StadiumDto> findAll(final String location,
                                    final Integer minPrice,
                                    final Integer maxPrice) {
        final Integer max = maxPrice != null ? maxPrice : Integer.MAX_VALUE;
        final Integer min = minPrice != null ? minPrice : 0;
        return mapper.toDtos(repository.findAll(location, min, max));
    }

    public Stadium create(final StadiumDto dto) {
        final Stadium stadium = mapper.toEntity(dto);
        return repository.save(mapper.toEntity(dto));
    }
}
