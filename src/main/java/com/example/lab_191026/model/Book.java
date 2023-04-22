package com.example.lab_191026.model;

//: id (Long), name (String),
//        category (enum), author (Author), availableCopies (Integer)

import com.example.lab_191026.model.enumeration.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book( String name, Category category, Author author, Integer availableCopies) {

        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }
}
