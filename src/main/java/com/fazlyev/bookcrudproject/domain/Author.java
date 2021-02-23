package com.fazlyev.bookcrudproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    @Field("name")
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author: " + name;
    }
}
