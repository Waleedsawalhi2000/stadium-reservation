package org.stadium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stadium.dto.LocationDto;
import org.stadium.dto.MediaDto;
import org.stadium.dto.RequestDto;
import org.stadium.dto.StadiumDto;
import org.stadium.entity.Media;
import org.stadium.entity.Request;
import org.stadium.entity.Stadium;
import org.stadium.mapper.LocationMapper;
import org.stadium.mapper.MediaMapper;
import org.stadium.mapper.StadiumMapper;
import org.stadium.repository.LocationRepository;
import org.stadium.repository.MediaRepository;
import org.stadium.repository.RequestRepository;
import org.stadium.repository.StadiumRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StadiumService extends AbstractService<Stadium, StadiumDto, Integer> {
    private final StadiumRepository repository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private MediaRepository mediaRepository;


    public StadiumService(final StadiumRepository repository) {
        super(new StadiumMapper(), repository);
        this.repository = repository;
    }

    public List<StadiumDto> findAll(final String username) {
        return mapper.toDtos(repository.findAll(username));
    }

    public List<StadiumDto> findAll(final String location,
                                    final Integer minPrice,
                                    final Integer maxPrice,
                                    final String name) {
        final Integer max = maxPrice != null ? maxPrice : Integer.MAX_VALUE;
        final Integer min = minPrice != null ? minPrice : 0;
        return mapper.toDtos(repository.findAll(location, min, max, name));
    }

    public Stadium create(final StadiumDto dto) {
        final Stadium stadium = mapper.toEntity(dto);
        mediaRepository.save(new MediaMapper().toEntity((MediaDto) dto.getImage().setId(null)));
        locationRepository.save(new LocationMapper().toEntity((LocationDto) dto.getLocation().setId(null)));
        return repository.save(mapper.toEntity(dto));
    }

    public Stadium update(final StadiumDto dto,
                          final Integer id) {
        mediaRepository.save(new MediaMapper().toEntity(dto.getImage().getId() != null ? dto.getImage() : dto.getImage().setId(null)));
        locationRepository.save(new LocationMapper().toEntity(dto.getLocation().getId() != null ? dto.getLocation() : dto.getLocation().setId(null)));
        return repository.save(mapper.toEntity(dto));
    }

    @Override
    public Boolean delete(Integer integer) {
        final List<Request> requests = repository.findById(integer).get().getRequests();
        requestRepository.deleteAllById(requests.stream().map(i -> i.getId()).collect(Collectors.toList()));
        return super.delete(integer);
    }
}
