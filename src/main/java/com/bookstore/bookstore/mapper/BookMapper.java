package com.bookstore.bookstore.mapper;

import com.bookstore.bookstore.dto.BookRequestDTO;
import com.bookstore.bookstore.dto.BookResponseDTO;
import com.bookstore.bookstore.model.Book;

public class BookMapper {
    // Entity → Response DTO
    public static BookResponseDTO toDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        return dto;
    }

    // Request DTO → Entity
    public static Book toEntity(BookRequestDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return book;
    }

    // Update existing entity
    public static void updateEntity(Book book, BookRequestDTO dto) {
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
    }
}
