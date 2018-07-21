package com.cafe.manager.service;

import com.cafe.manager.domain.ProductInOrder;

import java.util.List;

public interface ProductInOrderService {
    ProductInOrder findById(Long id);
    ProductInOrder register(ProductInOrder productInOrder);
    List<ProductInOrder> findAll();
    List<ProductInOrder> findByOrderId(Long id);
}
