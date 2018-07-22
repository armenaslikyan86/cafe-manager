package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Order;
import com.cafe.manager.repository.OrderRepository;
import com.cafe.manager.service.OrderService;
import com.cafe.manager.service.TableService;
import com.cafe.manager.service.exception.ResourceDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TableService tableService;

    @Override
    @Transactional
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceDoesNotExistException("Order does not exist"));
    }

    @Override
    public Order modify(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Set<Order> getAllByTableId(Long tableId) {
        return tableService.getById(tableId).getOrders();
    }
}
