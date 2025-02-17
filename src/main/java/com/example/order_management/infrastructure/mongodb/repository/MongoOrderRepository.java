package com.example.order_management.infrastructure.mongodb.repository;

import com.example.order_management.domain.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoOrderRepository extends MongoRepository<Order, String> {
}
