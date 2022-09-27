package com.springpostgreSQLexample.springpostgreSQLexample.repo;

import com.springpostgreSQLexample.springpostgreSQLexample.entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Kisi, Long> {
}

