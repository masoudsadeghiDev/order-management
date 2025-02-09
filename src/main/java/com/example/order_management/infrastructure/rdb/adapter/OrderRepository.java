package com.example.order_management.infrastructure.rdb.adapter;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order_management.domain.entity.Order;
import com.example.order_management.domain.enums.OrderStatus;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
}