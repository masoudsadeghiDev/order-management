package com.example.order_management.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order_management.domain.entity.Order;
import com.example.order_management.domain.enums.OrderStatus;
import com.example.order_management.infrastructure.rdb.adapter.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }
}
