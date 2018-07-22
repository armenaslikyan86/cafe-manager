package com.cafe.manager.service;

import com.cafe.manager.domain.Order;

import java.util.Set;

public interface OrderService {
    Order getById(Long id);

    Order modify(Order order);

    Set<Order> getAllByTableId(Long tableId);
}
