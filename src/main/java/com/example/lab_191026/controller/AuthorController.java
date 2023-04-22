package com.example.lab_191026.controller;

import com.example.lab_191026.model.Author;
import com.example.lab_191026.model.dTo.AuthorDto;
import com.example.lab_191026.service.interfaces.AuthorServiceI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorServiceI authorService;

    public AuthorController(AuthorServiceI authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<Author> findAll() {
        return this.authorService.listAll();
    }

    @PostMapping()
    public void saveAuthor(@RequestBody AuthorDto authorDto) {
        this.authorService.create(authorDto);
    }

}
