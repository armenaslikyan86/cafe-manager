package com.cafe.manager.service;

import com.cafe.manager.domain.ProductInOrder;

import java.util.List;
import java.util.Set;

public interface ProductInOrderService {
    ProductInOrder findById(Long id);

    ProductInOrder modify(ProductInOrder productInOrder);
    List<ProductInOrder> findAll();

    Set<ProductInOrder> findByOrderId(Long orderId);
}
