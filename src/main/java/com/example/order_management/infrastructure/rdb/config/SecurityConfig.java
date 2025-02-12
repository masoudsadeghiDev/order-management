package com.example.order_management.infrastructure.rdb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/signup", "/api/users/login").permitAll()  // Public routes
                // .requestMatchers("/api/admin/**").hasRole("ADMIN")  // Restricted to ADMIN role
                // .requestMatchers("/api/seller/**").hasRole("SELLER")  // Restricted to SELLER role
                // .requestMatchers("/api/customer/**").hasRole("CUSTOMER")  // Restricted to CUSTOMER role
                .anyRequest().authenticated()  // All other requests require authentication
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // Use stateless session

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
