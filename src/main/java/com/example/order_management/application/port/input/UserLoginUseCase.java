package com.example.order_management.application.port.input;

import com.example.order_management.domain.entity.User;
import com.example.order_management.domain.enums.Role;

public interface UserLoginUseCase {
    User login(String email, String password);    
    User signup(String email, String password,Role role);    
}
