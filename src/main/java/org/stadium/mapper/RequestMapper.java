package org.stadium.mapper;


import org.stadium.dto.RequestDto;
import org.stadium.entity.Request;


public class RequestMapper extends AbstractMapper<Request, RequestDto> {
    @Override
    public Request toEntity(RequestDto requestDto) {
        return requestDto == null ? null : Request
                .builder()
                .id(requestDto.getId())
                .user(new UserMapper().toEntity(requestDto.getUser()))
                .stadium(new StadiumMapper().toEntity(requestDto.getStadium()))
                .started(requestDto.getStarted())
                .ended(requestDto.getEnded())
                .paymentMethod(requestDto.getPaymentMethod())
                .status(requestDto.getStatus())
                .build();
    }

    @Override
    public RequestDto toDto(Request request) {
        return request == null ? null : RequestDto
                .builder()
                .id(request.getId())
                .user(new UserMapper().toDto(request.getUser().setStadiums(null).setRequests(null)))
                .stadium(new StadiumMapper().toDto(request.getStadium()))
                .started(request.getStarted())
                .ended(request.getEnded())
                .paymentMethod(request.getPaymentMethod())
                .status(request.getStatus())
                .build();
    }
}
