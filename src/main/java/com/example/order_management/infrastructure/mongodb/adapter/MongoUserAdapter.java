package com.example.order_management.infrastructure.mongodb.adapter;

import com.example.order_management.application.port.output.UserOutput;
import com.example.order_management.domain.entity.User;
import com.example.order_management.infrastructure.mongodb.repository.MongoUserRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoUserAdapter implements UserOutput {

    private final MongoUserRepository mongoUserRepository;

    public MongoUserAdapter(MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return mongoUserRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return mongoUserRepository.save(user);
    }
}

