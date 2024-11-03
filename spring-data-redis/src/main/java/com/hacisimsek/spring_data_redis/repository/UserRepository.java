package com.hacisimsek.spring_data_redis.repository;

import com.hacisimsek.spring_data_redis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}