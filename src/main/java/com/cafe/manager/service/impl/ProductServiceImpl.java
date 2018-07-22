package com.cafe.manager.service.impl;

import com.cafe.manager.domain.Product;
import com.cafe.manager.repository.ProductInOrderRepository;
import com.cafe.manager.repository.ProductRepository;
import com.cafe.manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product register(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findByProductInOrderId(Long id) {
//        return productInOrderRepository.findById(id).get().getProduct();
        return null;
    }
}
