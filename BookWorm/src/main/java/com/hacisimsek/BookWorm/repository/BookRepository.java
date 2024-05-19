package com.hacisimsek.BookWorm.repository;

import com.hacisimsek.BookWorm.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
}
