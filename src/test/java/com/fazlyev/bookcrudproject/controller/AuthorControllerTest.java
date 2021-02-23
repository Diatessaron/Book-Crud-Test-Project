package com.fazlyev.bookcrudproject.controller;

import com.fazlyev.bookcrudproject.domain.Author;
import com.fazlyev.bookcrudproject.service.AuthorServiceImpl;
import com.fazlyev.bookcrudproject.service.BookService;
import com.fazlyev.bookcrudproject.service.GenreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorServiceImpl authorService;
    @MockBean
    private BookService bookService;
    @MockBean
    private GenreService genreService;

    @Test
    void positiveTestGetAuthorByNameByStatus() throws Exception {
        when(authorService.findByName("Author")).thenReturn(List.of(new Author("Author")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/authors/Author"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeTestGetAuthorByNameByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/authors/Author"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveTestGetAllByStatus() throws Exception {
        when(authorService.findAll()).thenReturn(List.of(new Author("Author")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/authors"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeTestGetAllByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/authors"))
                .andExpect(status().isNotFound());
    }
}
