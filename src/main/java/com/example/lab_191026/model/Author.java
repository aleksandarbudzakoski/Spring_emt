package com.example.lab_191026.model;

//d (Long), name (String), surname (String), country (Country).
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    @ManyToOne
    private Country country;

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {
    }
}
