package com.example.order_management.infrastructure.rest.dto.request;

import com.example.order_management.domain.enums.Role;
import com.example.order_management.infrastructure.rest.validation.ValidRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @ValidRole
    @NotBlank(message = "Email is required")
    private Role role;
}
