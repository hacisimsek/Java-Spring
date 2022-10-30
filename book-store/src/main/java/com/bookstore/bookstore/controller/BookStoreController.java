package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dto.BookOrderRequest;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.BookOrder;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookstore")
public class BookStoreController {
    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.findAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<BookOrder>> getAllOrders() {
        List<BookOrder> orderList = orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }

    @PostMapping
    public ResponseEntity<BookOrder> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        BookOrder order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }


}
