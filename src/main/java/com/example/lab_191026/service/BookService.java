package com.example.lab_191026.service;

import com.example.lab_191026.model.Author;
import com.example.lab_191026.model.Book;
import com.example.lab_191026.model.dTo.BookDto;
import com.example.lab_191026.repository.AuthorRepository;
import com.example.lab_191026.repository.BookRepository;
import com.example.lab_191026.service.interfaces.BookServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceI {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }


    @Override
    public Page<Book> FindAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findbyId(Long id) {
        Book bookById = this.bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return bookById;
    }

    @Override
    public void create(BookDto bookDto) {
        Optional<Author> a = authorRepository.findById(bookDto.getAuthorId());
        if(!a.isPresent()){
            throw new RuntimeException("Author is not found");
        }
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), a.get(), bookDto.getAvailableCopies());
        bookRepository.save(book);
    }

    @Override
    public Book update(Long bookId, BookDto bookDto) {
        Optional<Book> b = bookRepository.findById(bookId);
        if(!b.isPresent()){
            throw new RuntimeException("The book is not found");
        }
        Book book = b.get();
        book.setCategory(bookDto.getCategory());
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        Optional<Author> a = authorRepository.findById(bookDto.getAuthorId());
        if(!a.isPresent()){
            throw new RuntimeException("Author is not found");
        }
        book.setAuthor(a.get());
        bookRepository.save(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        this.bookRepository.delete(book);
    }

    @Override
    public Book rentedBook(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(book.getAvailableCopies()>=1) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            this.bookRepository.save(book);
        }

        return book;
    }
}
