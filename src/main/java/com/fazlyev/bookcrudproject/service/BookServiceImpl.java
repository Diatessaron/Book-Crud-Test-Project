package com.fazlyev.bookcrudproject.service;

import com.fazlyev.bookcrudproject.domain.Book;
import com.fazlyev.bookcrudproject.dto.BookRequest;
import com.fazlyev.bookcrudproject.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByAuthor_Name(String name) {
        return bookRepository.findByAuthor_Name(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByGenre_Name(String name) {
        return bookRepository.findByGenre_Name(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByReadIsFalse() {
        return bookRepository.findByIsReadIsFalse();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByReadIsTrue() {
        return bookRepository.findByIsReadIsTrue();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByLikedIsTrue() {
        return bookRepository.findByIsLikedIsTrue();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public boolean setLiked(BookRequest bookRequest) {
        final Book book = bookRepository.findById(bookRequest.getId()).orElseThrow(
                () -> new IllegalArgumentException("Incorrect book id has been entered"));
        book.setLiked(bookRequest.isLiked());
        bookRepository.save(book);

        return true;
    }

    @Transactional
    @Override
    public boolean setRead(BookRequest bookRequest) {
        final Book book = bookRepository.findById(bookRequest.getId()).orElseThrow(
                () -> new IllegalArgumentException("Incorrect book id has been entered"));
        book.setRead(bookRequest.isRead());
        bookRepository.save(book);

        return true;
    }
}
