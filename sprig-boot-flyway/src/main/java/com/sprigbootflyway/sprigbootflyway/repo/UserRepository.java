package com.sprigbootflyway.sprigbootflyway.repo;

import com.sprigbootflyway.sprigbootflyway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}