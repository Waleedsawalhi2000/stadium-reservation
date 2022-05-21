package org.stadium.service;


import org.springframework.stereotype.Service;
import org.stadium.dto.OrderDto;
import org.stadium.entity.Order;
import org.stadium.mapper.OrderMapper;
import org.stadium.repository.OrderRepository;

@Service
public class OrderService extends AbstractService<Order, OrderDto, Integer> {
    public OrderService(final OrderRepository repository) {
        super(new OrderMapper(), repository);
    }
}
