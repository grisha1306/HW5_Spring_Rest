package com.company.controller;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Book;
import com.company.repository.BookRepository;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return service.save(book);
    }

    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.delete(id);
    }

    @PatchMapping("/books/{id}/{name}")
    public Map<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @PathVariable(value = "name") String name) throws ResourceNotFoundException {
        return service.update(id,name);
    }

    @PutMapping("/books/{id}")
    public Book fullUpdate(@RequestBody Book book) {

        return service.fullUpdate(book);
    }
}
