package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {

}
