package com.example.lab_191026.repository;

import com.example.lab_191026.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
