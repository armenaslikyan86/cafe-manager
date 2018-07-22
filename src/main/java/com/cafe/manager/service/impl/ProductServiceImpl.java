package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Product;
import com.cafe.manager.repository.ProductInOrderRepository;
import com.cafe.manager.repository.ProductRepository;
import com.cafe.manager.service.ProductInOrderService;
import com.cafe.manager.service.ProductService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInOrderService productInOrderService;

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product modify(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    public Product findByProductInOrderId(Long productInOrderId) {
        return productInOrderService.findById(productInOrderId).getProduct();
    }
}
