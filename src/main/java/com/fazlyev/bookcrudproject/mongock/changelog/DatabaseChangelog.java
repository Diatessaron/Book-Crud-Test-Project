package com.fazlyev.bookcrudproject.mongock.changelog;

import com.fazlyev.bookcrudproject.domain.Author;
import com.fazlyev.bookcrudproject.domain.Book;
import com.fazlyev.bookcrudproject.domain.Genre;
import com.fazlyev.bookcrudproject.repository.AuthorRepository;
import com.fazlyev.bookcrudproject.repository.BookRepository;
import com.fazlyev.bookcrudproject.repository.GenreRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

import java.util.List;

@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "dropDb", runAlways = true, author = "Diatessaron")
    public void dropDb(MongoDatabase db) {
        db.drop();
    }

    @ChangeSet(order = "002", id = "insertAuthors", runAlways = true, author = "Diatessaron")
    public void insertAuthors(AuthorRepository repository) {
        repository.saveAll(List.of(
                new Author("James Joyce"),
                new Author("Franz Kafka"),
                new Author("Hermann Hesse"),
                new Author("Charles Bukowski"),
                new Author("Goethe"),
                new Author("Philip Roth"),
                new Author("Salinger"),
                new Author("Georges Bataille"),
                new Author("Jack London"),
                new Author("George Orwell")
        ));
    }

    @ChangeSet(order = "003", id = "insertGenres", runAlways = true, author = "Diatessaron")
    public void insertGenres(GenreRepository repository) {
        repository.saveAll(List.of(
                new Genre("Modernist novel"),
                new Genre("Fiction"),
                new Genre("Collection of short stories"),
                new Genre("Tragic play"),
                new Genre("Novel"),
                new Genre("Allegorical novell")
        ));
    }

    @ChangeSet(order = "004", id = "insertBooks", runAlways = true, author = "Diatessaron")
    public void insertBooks(BookRepository repository) {
        repository.saveAll(List.of(
                new Book("Ulysses", new Author("James Joyce"), new Genre("Modernist novel")),
                new Book("The Trial", new Author("Franz Kafka"), new Genre("Fiction")),
                new Book("The Glass Bead Game", new Author("Hermann Hesse"), new Genre("Fiction")),
                new Book("South of No North", new Author("Charles Bukowski"),
                        new Genre("Collection of short stories")),
                new Book("Faust", new Author("Goethe"), new Genre("Tragic play")),
                new Book("The Human Stain", new Author("Philip Roth"), new Genre("Novel")),
                new Book("Nine Stories", new Author("Salinger"), new Genre("Collection of short stories")),
                new Book("Story of the Eye", new Author("Georges Bataille"), new Genre("Novel")),
                new Book("Martin Eden", new Author("Jack London"), new Genre("Novel")),
                new Book("Animal Farm", new Author("George Orwell"), new Genre("Allegorical novell"))
        ));
    }
}
