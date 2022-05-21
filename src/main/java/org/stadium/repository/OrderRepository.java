package org.stadium.repository;

import org.springframework.stereotype.Repository;
import org.stadium.entity.Order;

@Repository
public interface OrderRepository extends AbstractJpaRepository<Order, Integer> {
}
