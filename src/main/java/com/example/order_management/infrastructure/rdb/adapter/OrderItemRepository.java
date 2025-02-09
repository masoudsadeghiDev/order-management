package com.example.order_management.infrastructure.rdb.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order_management.domain.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
