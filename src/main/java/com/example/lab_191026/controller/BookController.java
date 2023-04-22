package com.example.lab_191026.controller;

import com.example.lab_191026.model.Book;
import com.example.lab_191026.model.dTo.BookDto;
import com.example.lab_191026.service.interfaces.BookServiceI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceI bookService;

    public BookController(BookServiceI bookService) {
        this.bookService = bookService;

    }

    @GetMapping()
    public List<Book> findAll(){
        return this.bookService.listAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return  this.bookService.findbyId(id);
    }

    @GetMapping("/pagination")
    public Page<Book> findAll(Pageable pageable) {
        return this.bookService.FindAllWithPagination(pageable);
    }

    @PostMapping("/create")
    public void create(@RequestBody BookDto bookDto) {
        this.bookService.create(bookDto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editById(@PathVariable Long id,
                                         @RequestBody BookDto bookDto) {
        return ResponseEntity.ok().body(this.bookService.update(id,bookDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rented/{id}")
    public ResponseEntity<Book> rentedBook(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(this.bookService.rentedBook(id));
    }
}
