package com.company.controller;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Book;
import com.company.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/books/{id}")
    public Map<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @RequestBody Book book) throws ResourceNotFoundException {
        return service.update(id,book);
    }

    @PutMapping("/books/{id}")
    public Book fullUpdate(@RequestBody Book book, @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        return service.fullUpdate(id, book);
    }

    @GetMapping("/books/name-price")
    public List<String> nameAndPrice() {
        return service.nameAndPrice();
    }

    @GetMapping("/books/name-price-windows-20000")
    public List<String> nameAndPriceMore20000() {
        return service.nameAndPriceMore20000();
    }
}
