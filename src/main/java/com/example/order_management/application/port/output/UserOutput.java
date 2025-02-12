package com.example.order_management.application.port.output;

import java.util.Optional;

import com.example.order_management.domain.entity.User;

public interface UserOutput {
    Optional<User> findByEmail(String email);
    User save(User user);
}
