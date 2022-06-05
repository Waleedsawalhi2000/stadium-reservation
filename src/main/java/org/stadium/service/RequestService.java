package org.stadium.service;


import org.springframework.stereotype.Service;
import org.stadium.dto.*;
import org.stadium.entity.*;
import org.stadium.mapper.RequestMapper;
import org.stadium.repository.RequestRepository;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService extends AbstractService<Request, RequestDto, Integer> {
    private final RequestRepository repository;
    public RequestService(final RequestRepository repository) {
        super(new RequestMapper(), repository);
        this.repository = repository;
    }

    public List<RequestDto> findAll(final String username,
                                    final String status) {
        final List<Request> requests = repository.findAll(username, status);
        final List<RequestDto> results = new ArrayList<>();
        for (int i = 0; i < requests.size() ; i++) {
            final Request request = requests.get(i);
            final RequestDto dto = new RequestDto();
            dto.setId(request.getId());
            dto.setStadium(getStadiumDto(request.getStadium()));
            dto.setUser(getUserDto(request.getUser()));
            dto.setDate(request.getStarted().toLocalDate());
            dto.setStarted(request.getStarted().getHour());
            dto.setEnded(request.getEnded().getHour());
            dto.setTotalPrice(request.getTotalPrice());
            dto.setPaymentMethod(request.getPaymentMethod());
            dto.setStatus(request.getStatus());
            results.add(dto);
        }
        return results;
    }


    public List<RequestDto> findAll(final String username) {
        final List<Request> requests = repository.findAll(username);
        final List<RequestDto> results = new ArrayList<>();
        for (int i = 0; i < requests.size() ; i++) {
            final Request request = requests.get(i);
            final RequestDto dto = new RequestDto();
            dto.setId(request.getId());
            dto.setStadium(getStadiumDto(request.getStadium()));
            dto.setUser(getUserDto(request.getUser()));
            dto.setDate(request.getStarted().toLocalDate());
            dto.setStarted(request.getStarted().getHour());
            dto.setEnded(request.getEnded().getHour());
            dto.setTotalPrice(request.getTotalPrice());
            dto.setPaymentMethod(request.getPaymentMethod());
            dto.setStatus(request.getStatus());
            results.add(dto);
        }
        return results;
    }

    public UserDto getUserDto(final User user) {
        final UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setUserId(user.getUserId());
        dto.setActive(user.getActive());
        dto.setRoles(user.getRoles());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setLastname(user.getLastname());
        dto.setFirstname(user.getFirstname());
        dto.setVerified(user.getVerified());
        return dto;
    }


    public StadiumDto getStadiumDto(final Stadium stadium) {
        final StadiumDto stadiumDto = new StadiumDto();
        stadiumDto.setId(stadium.getId());
        stadiumDto.setName(stadium.getName());
        stadiumDto.setAdmin(null);
        stadiumDto.setRequests(null);
        Media image = stadium.getImage();
        stadiumDto.setImage(new MediaDto(image.getImage(), image.getName(), image.getUri()));
        stadiumDto.setStadiumId(stadium.getStadiumId());
        Location location = stadium.getLocation();
        stadiumDto.setLocation(LocationDto.builder().id(location.getId()).name(location.getName()).city(location.getCity()).street(location.getStreet()).build());
        stadiumDto.setPrice(stadium.getPrice());
        stadiumDto.setSize(stadium.getSize());
        stadiumDto.setPhoneNumber(stadium.getPhoneNumber());
        stadiumDto.setDescription(stadium.getDescription());
        return stadiumDto;
    }
}
