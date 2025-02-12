package com.example.order_management.infrastructure.rest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RoleValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRole {
    String message() default "Role must be either CUSTOMER or SELLER";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}