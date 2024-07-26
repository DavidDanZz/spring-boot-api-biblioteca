package com.example.biblioteca.service;

import com.example.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book createBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return getBookById(id).map(existingBook -> {
            existingBook.setTitulo(updatedBook.getTitulo());
            existingBook.setAutor(updatedBook.getAutor());
            existingBook.setDescricao(updatedBook.getDescricao());
            return existingBook;
        });
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
