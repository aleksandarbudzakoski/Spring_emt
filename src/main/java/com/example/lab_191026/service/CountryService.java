package com.example.lab_191026.service;

import com.example.lab_191026.model.Country;
import com.example.lab_191026.repository.CountryRepository;
import com.example.lab_191026.service.interfaces.CountryServiceI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements CountryServiceI {


    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name,continent);
        this.countryRepository.save(country);
        return country;
    }
}
