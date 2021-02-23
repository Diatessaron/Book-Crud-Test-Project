package com.fazlyev.bookcrudproject.controller;

import com.fazlyev.bookcrudproject.domain.Genre;
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
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GenreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorServiceImpl authorService;
    @MockBean
    private BookService bookService;
    @MockBean
    private GenreService genreService;

    @Test
    void positiveTestGetGenreByNameByStatus() throws Exception {
        when(genreService.findByName("Genre")).thenReturn(Optional.of(new Genre("Genre")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/Genre"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeTestGetGenreByNameByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres/Genre"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveTestGetAllByStatus() throws Exception {
        when(genreService.findAll()).thenReturn(List.of(new Genre("Genre")));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeTestGetAllByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/genres"))
                .andExpect(status().isNotFound());
    }
}
