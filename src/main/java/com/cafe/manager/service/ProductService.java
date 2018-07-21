package com.cafe.manager.service;

import com.cafe.manager.domain.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long id);

    Product register(Product product);

    List<Product> findAll();

    Product findByProductInOrderId(Long id);
}
