package com.fazlyev.bookcrudproject.controller;

import com.fazlyev.bookcrudproject.domain.Genre;
import com.fazlyev.bookcrudproject.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/api/genres/{name}")
    public ResponseEntity<Genre> findByName(@PathVariable String name) {
        return ResponseEntity.of(genreService.findByName(name));
    }

    @GetMapping("/api/genres")
    public ResponseEntity<List<Genre>> findAll() {
        final List<Genre> genres = genreService.findAll();

        if (genres.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(genres);
    }
}
