package com.cafe.manager.service;

import com.cafe.manager.domain.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);

    Product modify(Product product);

    List<Product> findAll();

    Product findByProductInOrderId(Long productInOrderId);
}
