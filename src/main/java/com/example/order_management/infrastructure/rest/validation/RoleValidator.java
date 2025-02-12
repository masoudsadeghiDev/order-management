package com.example.order_management.infrastructure.rest.validation;

import com.example.order_management.domain.enums.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.EnumSet;

public class RoleValidator implements ConstraintValidator<ValidRole, Role> {
    
    private static final EnumSet<Role> VALID_ROLES = EnumSet.of(Role.CUSTOMER, Role.SELLER);

    @Override
    public boolean isValid(Role role, ConstraintValidatorContext context) {
        return role != null && VALID_ROLES.contains(role);
    }
}