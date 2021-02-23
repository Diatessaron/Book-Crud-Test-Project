package com.fazlyev.bookcrudproject.service;

import com.fazlyev.bookcrudproject.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findByName(String name);

    List<Author> findAll();
}
