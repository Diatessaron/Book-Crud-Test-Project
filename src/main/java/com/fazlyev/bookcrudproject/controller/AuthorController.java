package com.fazlyev.bookcrudproject.controller;

import com.fazlyev.bookcrudproject.domain.Author;
import com.fazlyev.bookcrudproject.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/bookshelf/api/authors/{name}")
    public ResponseEntity<List<Author>> findByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findByName(name));
    }

    @GetMapping("/bookshelf/api/authors")
    public ResponseEntity<List<Author>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findAll());
    }
}
