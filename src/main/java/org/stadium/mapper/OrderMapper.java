package org.stadium.mapper;


import org.stadium.dto.OrderDto;
import org.stadium.entity.Order;


public class OrderMapper extends AbstractMapper<Order, OrderDto> {
    @Override
    public Order toEntity(OrderDto orderDto) {
        return Order
                .builder()
                .id(orderDto.getId())
                .user(new UserMapper().toEntity(orderDto.getUser()))
                .stadium(new StadiumMapper().toEntity(orderDto.getStadium()))
                .started(orderDto.getStarted())
                .ended(orderDto.getEnded())
                .paymentMethod(orderDto.getPaymentMethod())
                .build();
    }

    @Override
    public OrderDto toDto(Order order) {
        return OrderDto
                .builder()
                .id(order.getId())
                .user(new UserMapper().toDto(order.getUser()))
                .stadium(new StadiumMapper().toDto(order.getStadium()))
                .started(order.getStarted())
                .ended(order.getEnded())
                .paymentMethod(order.getPaymentMethod())
                .build();
    }
}
