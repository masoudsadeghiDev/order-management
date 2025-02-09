package com.example.order_management.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.order_management.domain.entity.User;
import com.example.order_management.infrastructure.rdb.adapter.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
