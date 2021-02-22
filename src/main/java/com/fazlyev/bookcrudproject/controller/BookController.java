package com.fazlyev.bookcrudproject.controller;

import com.fazlyev.bookcrudproject.domain.Book;
import com.fazlyev.bookcrudproject.dto.BookRequest;
import com.fazlyev.bookcrudproject.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookshelf/api/books/title/{title}")
    public ResponseEntity<List<Book>> findByTitle(@PathVariable String title) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findByTitle(title));
    }

    @GetMapping("/bookshelf/api/books/author/{authorName}")
    public ResponseEntity<List<Book>> findByAuthorName(@PathVariable String authorName) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findByAuthor_Name(authorName));
    }

    @GetMapping("/bookshelf/api/books/genre/{genreName}")
    public ResponseEntity<List<Book>> findByGenreName(@PathVariable String genreName) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findByGenre_Name(genreName));
    }

    @GetMapping("/bookshelf/api/books/read")
    public ResponseEntity<List<Book>> findByReadParameter(@RequestParam Boolean isRead) {
        if (isRead)
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findByReadIsTrue());
        else
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findByReadIsFalse());
    }

    @GetMapping("/bookshelf/api/books/liked")
    public ResponseEntity<List<Book>> findByLikedIsTrue() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findByLikedIsTrue());
    }

    @GetMapping("/bookshelf/api/books")
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }

    @PutMapping("/bookshelf/api/books/change/like")
    public ResponseEntity<Void> setIsLiked(@RequestBody BookRequest bookRequest) {
        if (bookService.setLiked(bookRequest))
            return ResponseEntity.status(HttpStatus.OK).build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/bookshelf/api/books/change/read")
    public ResponseEntity<Void> setIsRead(@RequestBody BookRequest bookRequest) {
        if (bookService.setRead(bookRequest))
            return ResponseEntity.status(HttpStatus.OK).build();
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
