package org.stadium.mapper;


import org.stadium.dto.RequestDto;
import org.stadium.entity.Request;


public class RequestMapper extends AbstractMapper<Request, RequestDto> {
    @Override
    public Request toEntity(RequestDto requestDto) {
        return Request
                .builder()
                .id(requestDto.getId())
//                .user(new UserMapper().toEntity(orderDto.getUser()))
//                .stadium(new StadiumMapper().toEntity(orderDto.getStadium()))
//                .started(orderDto.getStarted())
//                .ended(orderDto.getEnded())
//                .paymentMethod(orderDto.getPaymentMethod())
                .build();
    }

    @Override
    public RequestDto toDto(Request request) {
        return RequestDto
                .builder()
                .id(request.getId())
//                .user(new UserMapper().toDto(order.getUser()))
//                .stadium(new StadiumMapper().toDto(order.getStadium()))
//                .started(order.getStarted())
//                .ended(order.getEnded())
//                .paymentMethod(order.getPaymentMethod())
                .build();
    }
}
