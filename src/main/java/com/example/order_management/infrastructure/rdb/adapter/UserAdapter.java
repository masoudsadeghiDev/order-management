package com.example.order_management.infrastructure.rdb.adapter;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.order_management.application.port.output.UserOutput;
import com.example.order_management.domain.entity.User;
import com.example.order_management.infrastructure.rdb.repository.UserRepository;

@Service
@Primary
public class UserAdapter implements UserOutput {

    private final UserRepository repository;

    public UserAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

}
