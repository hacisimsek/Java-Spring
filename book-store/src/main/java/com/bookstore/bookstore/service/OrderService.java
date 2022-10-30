package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.BookOrder;
import com.bookstore.bookstore.repository.BookOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;
    private final BookOrderRepository bookOrderRepository;

    public OrderService(BookService bookService, BookOrderRepository bookOrderRepository) {
        this.bookService = bookService;
        this.bookOrderRepository = bookOrderRepository;
    }

    public BookOrder putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

        Double totalPrice = bookList.stream()
                .map(optionalBook -> optionalBook.map(Book::getPrice).orElse(0.0))
                .reduce(0.0, Double::sum);

        BookOrder order = BookOrder.builder()
                .bookIdList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return bookOrderRepository.save(order);
    }

    public List<BookOrder> getAllOrders(){
        return bookOrderRepository.findAll();
    }

}
