package com.example.order_management.infrastructure.mongodb.repository;

import com.example.order_management.domain.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoProductRepository extends MongoRepository<Product, String> {
}

