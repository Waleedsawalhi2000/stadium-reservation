package org.stadium.mapper;


import org.stadium.dto.RequestDto;
import org.stadium.entity.Request;
import org.stadium.entity.Stadium;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class RequestMapper extends AbstractMapper<Request, RequestDto> {
    @Override
    public Request toEntity(RequestDto requestDto) {
        return requestDto == null ? null : Request
                .builder()
                .id(requestDto.getId())
                .user(new UserMapper().toEntity(requestDto.getUser()))
                .stadium(new StadiumMapper().toEntity(requestDto.getStadium()))
                .started(getLocalDateTime(requestDto.getDate(), requestDto.getStarted()))
                .ended(requestDto.getEnded() >= 23 ? getLocalDateTime(requestDto.getDate(), requestDto.getEnded()) : getLocalDateTime(requestDto.getDate().plusDays(1), requestDto.getEnded() - requestDto.getStarted()))
                .paymentMethod(requestDto.getPaymentMethod())
                .status(requestDto.getStatus())
                .totalPrice(requestDto.getTotalPrice())
                .build();
    }

    @Override
    public RequestDto toDto(Request request) {
        return request == null ? null : RequestDto
                .builder()
                .id(request.getId())
                .user(new UserMapper().toDto(request.getUser().setStadiums(null).setRequests(null)))
                .stadium(new StadiumMapper().toDto(request.getStadium()))
                .started(request.getStarted().getHour())
                .ended(request.getEnded().getHour())
                .date(request.getStarted().toLocalDate())
                .paymentMethod(request.getPaymentMethod())
                .status(request.getStatus())
                .build();
    }


    public LocalDateTime getLocalDateTime(final LocalDate date, final Integer hour) {
        return LocalDateTime.of(date, LocalTime.of(hour, 0));
    }
}
