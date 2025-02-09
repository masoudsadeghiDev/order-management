package com.example.order_management.infrastructure.rdb.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order_management.application.port.output.UserOutput;
import com.example.order_management.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long>,UserOutput {
    
}