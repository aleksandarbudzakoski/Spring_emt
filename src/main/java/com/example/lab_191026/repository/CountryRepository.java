package com.example.lab_191026.repository;

import com.example.lab_191026.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
