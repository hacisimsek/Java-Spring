package com.springpostgreSQLexample.springpostgreSQLexample.repo;

import com.springpostgreSQLexample.springpostgreSQLexample.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Long> {
}
