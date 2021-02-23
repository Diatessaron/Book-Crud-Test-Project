package com.fazlyev.bookcrudproject.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "genres")
public class Genre {
    @Id
    private String id;
    @Field("name")
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
