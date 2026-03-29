package com.bookstore.bookstore.service;

import com.bookstore.bookstore.dto.BookRequestDTO;
import com.bookstore.bookstore.dto.BookResponseDTO;
import com.bookstore.bookstore.exception.BookNotFoundException;
import com.bookstore.bookstore.mapper.BookMapper;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> bookList = repo.findAll();
        List<BookResponseDTO> dtoList = new ArrayList<>();
        for (Book book : bookList) {
            BookResponseDTO dto = BookMapper.toDTO(book);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: "+id));
        return BookMapper.toDTO(book);
    }

    @Override
    public BookResponseDTO saveBook(BookRequestDTO dto) {
        Book book = BookMapper.toEntity(dto);
        Book saved = repo.save(book);
        return BookMapper.toDTO(saved);
    }


    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO dto) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: "+id));
        BookMapper.updateEntity(book, dto);
        Book updated = repo.save(book);
        return BookMapper.toDTO(updated);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = repo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found id: "+id));
        repo.delete(book);
    }
}
