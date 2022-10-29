package com.sprigbootwebfluxmongo.sprigbootwebfluxmongo.repo;

import com.sprigbootwebfluxmongo.sprigbootwebfluxmongo.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}