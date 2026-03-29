package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookRequestDTO;
import com.bookstore.bookstore.dto.BookResponseDTO;
import com.bookstore.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();

    BookResponseDTO getBookById(Long id);

    BookResponseDTO saveBook(BookRequestDTO dto);

    BookResponseDTO updateBook(Long id, BookRequestDTO dto);

    void deleteBook(Long id);
}
