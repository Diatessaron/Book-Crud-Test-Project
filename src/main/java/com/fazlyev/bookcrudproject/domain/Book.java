package com.fazlyev.bookcrudproject.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    @Field("title")
    private String title;
    @Field("author")
    private Author author;
    @Field("genre")
    private Genre genre;
    @Field("isLiked")
    private boolean isLiked;
    @Field("isRead")
    private boolean isRead;

    public Book(){
        this.isLiked = false;
        this.isRead = false;
    }

    public Book(String title, Author author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isLiked = false;
        this.isRead = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", isLiked=" + isLiked +
                ", isRead=" + isRead +
                '}';
    }
}
