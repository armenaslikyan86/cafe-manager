package com.cafe.manager.service.impl;

import com.cafe.manager.domain.ProductInOrder;
import com.cafe.manager.repository.ProductInOrderRepository;
import com.cafe.manager.service.OrderService;
import com.cafe.manager.service.ProductInOrderService;
import com.cafe.manager.service.exception.ResourceDoesNotExistException;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public ProductInOrder findById(Long id) {

        return productInOrderRepository.findById(id).orElseThrow(() -> new ResourceDoesNotExistException("Product in order does not exist"));
    }

    @Override
    public ProductInOrder modify(ProductInOrder productInOrder) {
        return productInOrderRepository.save(productInOrder);
    }

    @Override
    public List<ProductInOrder> findAll() {
        return Lists.newArrayList(productInOrderRepository.findAll());
    }

    @Override
    public Set<ProductInOrder> findByOrderId(Long orderId) {
        return orderService.getById(orderId).getProductInOrders();
    }
}
