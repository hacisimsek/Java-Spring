package com.hacisimsek.spring_security_with_jwt.repositories;

import com.hacisimsek.spring_security_with_jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}