package com.fazlyev.bookcrudproject.repository;

import com.fazlyev.bookcrudproject.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, String> {
    Optional<Genre> findByName(String name);
}
