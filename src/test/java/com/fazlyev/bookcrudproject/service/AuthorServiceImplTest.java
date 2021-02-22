package com.fazlyev.bookcrudproject.service;

import com.fazlyev.bookcrudproject.domain.Author;
import com.fazlyev.bookcrudproject.repository.AuthorRepository;
import com.fazlyev.bookcrudproject.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuthorServiceImplTest {
    @MockBean
    private AuthorRepository authorRepository;
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private AuthorServiceImpl service;

    private final Author jamesJoyce = new Author("James Joyce");

    @Test
    void shouldReturnCorrectAuthorByName() {
        when(authorRepository.findByName(jamesJoyce.getName())).thenReturn(List.of(jamesJoyce));

        final List<Author> actual = service.findByName(jamesJoyce.getName());

        assertEquals(List.of(jamesJoyce), actual);

        verify(authorRepository, times(1)).findByName(jamesJoyce.getName());
    }
}
