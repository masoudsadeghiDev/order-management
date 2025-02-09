package com.example.order_management.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order_management.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}