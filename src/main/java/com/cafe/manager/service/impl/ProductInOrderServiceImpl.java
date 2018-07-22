package com.cafe.manager.service.impl;

import com.cafe.manager.domain.ProductInOrder;
import com.cafe.manager.repository.OrderRepository;
import com.cafe.manager.repository.ProductInOrderRepository;
import com.cafe.manager.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ProductInOrder findById(Long id) {
        return productInOrderRepository.findById(id).get();
    }

    @Override
    public ProductInOrder register(ProductInOrder productInOrder) {
        return productInOrderRepository.save(productInOrder);
    }

    @Override
    public List<ProductInOrder> findAll() {
        return (List<ProductInOrder>) productInOrderRepository.findAll();
    }

    @Override
    public Set<ProductInOrder> findByOrderId(Long id) {
        return orderRepository.findById(id).get().getProductInOrders();
    }
}
