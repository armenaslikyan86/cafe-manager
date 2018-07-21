package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Order;
import com.cafe.manager.repository.OrderRepository;
import com.cafe.manager.repository.TableRepository;
import com.cafe.manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TableRepository tableRepository;

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order register(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByTableId(Long id) {
        return (List<Order>) tableRepository.findOne(id).getOrders();
    }
}
