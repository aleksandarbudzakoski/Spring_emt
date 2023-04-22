package com.example.lab_191026.service.interfaces;

import com.example.lab_191026.model.Country;

import java.util.List;

public interface CountryServiceI {

    List<Country> listAll();

    Country create(String name, String continent);
}
