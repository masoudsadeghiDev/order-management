package com.example.order_management.infrastructure.rest.dto.request;

import com.example.order_management.domain.enums.Role;
import com.example.order_management.infrastructure.rest.validation.ValidRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignupRequest(
        @NotBlank(message = "Email is required") 
        @Email(message = "Invalid email format") 
        String email,

        @NotBlank(message = "Password is required") 
        String password,

        @ValidRole
        Role role) {
}