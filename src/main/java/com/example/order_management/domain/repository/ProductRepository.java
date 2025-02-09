package com.example.order_management.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order_management.domain.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContaining(String name);
}