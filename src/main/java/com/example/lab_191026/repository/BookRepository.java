package com.example.lab_191026.repository;

import com.example.lab_191026.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
     Optional<Book> findById(Long id);
     Page<Book> findAll(Pageable pageable);

}
