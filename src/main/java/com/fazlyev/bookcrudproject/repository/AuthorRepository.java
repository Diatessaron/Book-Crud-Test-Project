package com.fazlyev.bookcrudproject.repository;

import com.fazlyev.bookcrudproject.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findByName(String name);
}
