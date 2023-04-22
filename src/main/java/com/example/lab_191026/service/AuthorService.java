package com.example.lab_191026.service;

import com.example.lab_191026.model.Author;
import com.example.lab_191026.model.Country;
import com.example.lab_191026.model.dTo.AuthorDto;
import com.example.lab_191026.repository.AuthorRepository;
import com.example.lab_191026.repository.CountryRepository;
import com.example.lab_191026.service.interfaces.AuthorServiceI;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService implements AuthorServiceI {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public void create(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getCountryId()).orElseThrow(EntityNotFoundException::new);

        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        this.authorRepository.save(author);

    }
}
