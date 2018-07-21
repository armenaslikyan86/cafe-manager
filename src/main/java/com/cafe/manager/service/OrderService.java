package com.cafe.manager.service;

import com.cafe.manager.domain.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long id);
    Order register(Order order);
    List<Order> getOrdersByTableId(Long id);
}
