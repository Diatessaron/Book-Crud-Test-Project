package com.fazlyev.bookcrudproject.controller;

import com.fazlyev.bookcrudproject.domain.Author;
import com.fazlyev.bookcrudproject.domain.Book;
import com.fazlyev.bookcrudproject.domain.Genre;
import com.fazlyev.bookcrudproject.dto.BookRequest;
import com.fazlyev.bookcrudproject.service.AuthorServiceImpl;
import com.fazlyev.bookcrudproject.service.BookService;
import com.fazlyev.bookcrudproject.service.GenreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorServiceImpl authorService;
    @MockBean
    private BookService bookService;
    @MockBean
    private GenreService genreService;

    @Test
    void positiveFindByTitleTestByStatus() throws Exception {
        when(bookService.findByTitle("Book")).thenReturn(List.of(new Book("Book",
                new Author("Author"), new Genre("Genre"))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/title/Book"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeFindByTitleTestByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/title/Book"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveFindByAuthorNameTestByStatus() throws Exception {
        when(bookService.findByAuthor_Name("Author")).thenReturn(List.of(new Book("Book",
                new Author("Author"), new Genre("Genre"))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/author/Author"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeFindByAuthorNameTestByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/author/Author"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveFindByGenreNameTestByStatus() throws Exception {
        when(bookService.findByGenre_Name("Genre")).thenReturn(List.of(new Book("Book",
                new Author("Author"), new Genre("Genre"))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/genre/Genre"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeFindByGenreNameTestByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/genre/Genre"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveFindByReadParameterTestByStatus() throws Exception {
        when(bookService.findByReadIsTrue()).thenReturn(List.of(new Book("Book",
                new Author("Author"), new Genre("Genre"))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/read?isRead=true"))
                .andExpect(status().isOk());
    }

    @Test
    void findByLikedIsTrue() throws Exception {
        when(bookService.findByReadIsTrue()).thenReturn(List.of(new Book("Book",
                new Author("Author"), new Genre("Genre"))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/read?isRead=false"))
                .andExpect(status().isOk());
    }

    @Test
    void positiveFindAllTestByStatus() throws Exception {
        when(bookService.findAll()).thenReturn(List.of(new Book("Book",
                new Author("Author"), new Genre("Genre"))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeFindAllTestByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveSetIsLikedTestByStatus() throws Exception {
        when(bookService.setLiked(any()))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/change/like")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"id\", \"title\": \"title\", \"isLiked\": \"true\", \"isRead\": \"false\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeSetIsLikedTestByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/change/like")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"id\", \"title\": \"title\", \"isLiked\": \"true\", \"isRead\": \"false\"}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void positiveSetIsReadTestByStatus() throws Exception {
        when(bookService.setRead(any()))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/change/read")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"id\", \"title\": \"title\", \"isLiked\": \"false\", \"isRead\": \"true\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void negativeSetIsReadTestByStatus() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/change/read")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"id\", \"title\": \"title\", \"isLiked\": \"false\", \"isRead\": \"true\"}"))
                .andExpect(status().isNotFound());
    }
}
