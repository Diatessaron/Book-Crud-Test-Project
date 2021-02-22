package com.fazlyev.bookcrudproject.service;

import com.fazlyev.bookcrudproject.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    Optional<Genre> findByName(String name);

    List<Genre> findAll();
}
