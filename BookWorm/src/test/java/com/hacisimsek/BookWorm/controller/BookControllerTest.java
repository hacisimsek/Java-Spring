package com.hacisimsek.BookWorm.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hacisimsek.BookWorm.dto.BookDTO;
import com.hacisimsek.BookWorm.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO book1 = new BookDTO();
        book1.setTitle("Book 1");
        book1.setAuthor("Author 1");

        BookDTO book2 = new BookDTO();
        book2.setTitle("Book 2");
        book2.setAuthor("Author 2");

        given(bookService.getAllBooks()).willReturn(Arrays.asList(book1, book2));

        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'title':'Book 1','author':'Author 1'},{'title':'Book 2','author':'Author 2'}]"));
    }

    @Test
    public void testGetBookById() throws Exception {
        BookDTO book = new BookDTO();
        book.setTitle("Book 1");
        book.setAuthor("Author 1");

        given(bookService.getBookById(1L)).willReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'title':'Book 1','author':'Author 1'}"));
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO book = new BookDTO();
        book.setTitle("Book 1");
        book.setAuthor("Author 1");

        given(bookService.createBook(any(BookDTO.class))).willReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .contentType("application/json")
                        .content("{\"title\":\"Book 1\",\"author\":\"Author 1\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'title':'Book 1','author':'Author 1'}"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookDTO book = new BookDTO();
        book.setTitle("Book 1");
        book.setAuthor("Author 1");

        given(bookService.updateBook(1L, book)).willReturn(book);

        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                        .contentType("application/json")
                        .content("{\"title\":\"Book 1\",\"author\":\"Author 1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'title':'Book 1','author':'Author 1'}"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"))
                .andExpect(status().isNoContent());
    }

}