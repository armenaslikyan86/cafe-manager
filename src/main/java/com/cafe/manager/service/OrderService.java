package com.cafe.manager.service;

import com.cafe.manager.domain.Order;

import java.util.Set;

public interface OrderService {
    Order getOrderById(Long id);

    Order modify(Order order);

    Set<Order> getOrdersByTableId(Long tableId);
}
