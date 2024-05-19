package com.hacisimsek.BookWorm.service;

import com.hacisimsek.BookWorm.dto.BookDTO;
import com.hacisimsek.BookWorm.entity.Book;
import com.hacisimsek.BookWorm.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setAuthor("Test Author");

        Book book2 = new Book();
        book2.setTitle("Test Title 2");
        book2.setAuthor("Test Author 2");

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);

        assertEquals(bookService.getAllBooks().size(), 2);
    }

    @Test
    public void testGetBookById() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        assertEquals(bookService.getBookById(1L).getId(), 1L);
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setTitle("Test Title");
        book.setAuthor("Test Author");

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Title");
        bookDTO.setAuthor("Test Author");

        assertThat(bookService.createBook(bookDTO)).isNotNull();
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle("Test Title 2");
        bookDTO.setAuthor("Test Author 2");

        assertEquals(bookService.updateBook(1L, bookDTO).getTitle(), "Test Title 2");
    }

    @Test
    public void testDeleteBook() {
        when(bookRepository.existsById(1L)).thenReturn(true);

        bookService.deleteBook(1L);
    }
}
