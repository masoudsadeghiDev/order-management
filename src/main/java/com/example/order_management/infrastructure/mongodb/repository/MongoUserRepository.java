package com.example.order_management.infrastructure.mongodb.repository;

import com.example.order_management.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
