package com.example.order_management.application.service;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.order_management.application.port.input.UserLoginUseCase;
import com.example.order_management.application.port.output.UserOutput;
import com.example.order_management.domain.entity.User;
import com.example.order_management.domain.enums.Role;
import com.example.order_management.domain.exception.AuthenticationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserLoginUseCase {

    private final UserOutput userOutput;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(String email, String password) {
        Optional<User> user = userOutput.findByEmail(email);
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new AuthenticationException("Invalid email or password");
        }
        return user.get();
    }

    @Override
    public User signup(String email, String password, Role role) {
        Optional<User> existingUser = userOutput.findByEmail(email);
        if (!existingUser.isEmpty()) {
            throw new AuthenticationException("User already exist!");
        }

        String passwordEncoded = passwordEncoder.encode(password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoded);
        user.setRole(role);
        user.setUsername(email);
        userOutput.save(user);
        return user;
    }

}
