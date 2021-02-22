package com.fazlyev.bookcrudproject.repository;

import com.fazlyev.bookcrudproject.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor_Name(String name);

    List<Book> findByGenre_Name(String name);

    List<Book> findByIsReadIsFalse();

    List<Book> findByIsReadIsTrue();

    List<Book> findByIsLikedIsTrue();
}
