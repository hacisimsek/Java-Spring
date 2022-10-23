package com.springbootpagination.springbootpagination.repo;

import com.springbootpagination.springbootpagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
