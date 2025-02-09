package com.example.order_management.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order_management.domain.entity.Payment;
import com.example.order_management.domain.enums.PaymentStatus;
import com.example.order_management.infrastructure.rdb.adapter.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }
}
