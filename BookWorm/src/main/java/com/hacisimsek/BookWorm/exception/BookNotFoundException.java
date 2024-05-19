package com.hacisimsek.BookWorm.exception;

public class BookNotFoundException extends RuntimeException{
        public BookNotFoundException(Long id) {
            super("Book not found with id: " + id);
        }
}
