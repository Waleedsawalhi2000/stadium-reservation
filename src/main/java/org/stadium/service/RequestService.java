package org.stadium.service;


import org.springframework.stereotype.Service;
import org.stadium.dto.RequestDto;
import org.stadium.entity.Request;
import org.stadium.mapper.RequestMapper;
import org.stadium.repository.RequestRepository;

@Service
public class RequestService extends AbstractService<Request, RequestDto, Integer> {
    private final RequestRepository repository;
    public RequestService(final RequestRepository repository) {
        super(new RequestMapper(), repository);
        this.repository = repository;
    }
}
