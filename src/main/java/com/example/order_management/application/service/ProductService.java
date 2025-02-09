package com.example.order_management.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order_management.domain.entity.Product;
import com.example.order_management.infrastructure.rdb.adapter.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
