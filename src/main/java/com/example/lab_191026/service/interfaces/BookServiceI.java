package com.example.lab_191026.service.interfaces;

import com.example.lab_191026.model.Book;
import com.example.lab_191026.model.dTo.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookServiceI {

    List<Book> listAll();

    Page<Book> FindAllWithPagination(Pageable pageable);

    Book findbyId(Long id);

    void create(BookDto bookDto);

    Book update(Long bookId, BookDto bookDto);

    void delete(Long id);

    Book rentedBook(Long id);
}
