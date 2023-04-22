package com.example.lab_191026.service.interfaces;

import com.example.lab_191026.model.Author;
import com.example.lab_191026.model.dTo.AuthorDto;

import java.util.List;

public interface AuthorServiceI {

    List<Author> listAll();

    void create(AuthorDto authorDto);
}

