package com.fazlyev.bookcrudproject.service;

import com.fazlyev.bookcrudproject.domain.Author;
import com.fazlyev.bookcrudproject.domain.Book;
import com.fazlyev.bookcrudproject.domain.Genre;
import com.fazlyev.bookcrudproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceImplTest {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImpl service;

    private final Book expectedUlysses = new Book("Ulysses", new Author("James Joyce"),
            new Genre("Modernist novel"));

    @Test
    void shouldReturnCorrectBookByTitle() {
        final Author author = new Author("James Joyce");
        final Genre genre = new Genre("Modernist novel");
        final Book book = new Book("Ulysses", author, genre);

        when(bookRepository.findByTitle(book.getTitle())).thenReturn(List.of(book));

        final List<Book> actual = service.findByTitle(expectedUlysses.getTitle());

        assertEquals(List.of(expectedUlysses), actual);

        verify(bookRepository, times(1)).findByTitle(book.getTitle());
    }

    @Test
    void shouldReturnCorrectBookByGenre() {
        final Author author = new Author("James Joyce");
        final Genre genre = new Genre("Modernist novel");
        final Book book = new Book("Ulysses", author, genre);

        when(bookRepository.findByGenre_Name(book.getGenre().getName())).thenReturn(List.of(book));

        final List<Book> actual = service.findByGenre_Name(expectedUlysses.getGenre().getName());

        assertEquals(List.of(expectedUlysses), actual);

        verify(bookRepository, times(1)).findByGenre_Name(book.getGenre().getName());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    void shouldReturnCorrectListOfBooks() {
        final Author author = new Author("Michel Foucault");
        final Genre genre = new Genre("Philosophy");
        final Book book = new Book("Discipline And Punish", author, genre);
        final List<Book> expected = List.of(expectedUlysses, book);

        when(bookRepository.findAll()).thenReturn(List.of(expectedUlysses, book));

        final List<Book> actual = service.findAll();

        assertThat(actual).isNotNull().matches(a -> a.size() == expected.size());

        verify(bookRepository, times(1)).findAll();
    }
}
