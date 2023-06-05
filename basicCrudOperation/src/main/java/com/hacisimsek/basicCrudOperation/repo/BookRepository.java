package com.hacisimsek.basicCrudOperation.repo;

import com.hacisimsek.basicCrudOperation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
