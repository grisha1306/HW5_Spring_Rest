package com.company.service;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Book;
import com.company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(int id) throws ResourceNotFoundException {
        Book book = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("book not found by id: " + id)
        );

        return repository.getById(id);
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public Map<String,Boolean> delete (int id) throws ResourceNotFoundException {

        Book book = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("book not found by id: " + id)
        );

        repository.delete(book);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);

        return response;

    }

    public Map<String, Boolean> update(int id, Book book) throws ResourceNotFoundException {
        Book patchBook = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("book not found by id: " + id)
        );

        if (book.getName() != null)
            patchBook.setName(book.getName());

        if (book.getPrice() != null)
            patchBook.setPrice(book.getPrice());

        if (book.getWarehouse() != null)
            patchBook.setWarehouse(book.getWarehouse());

        if (book.getNum() != null)
            patchBook.setNum(book.getNum());

        repository.save(patchBook);

        Map<String, Boolean> response = new HashMap<>();

        response.put("patch update", true);

        return response;
    }

    public Book fullUpdate(int id, Book book) throws ResourceNotFoundException {
        Book bookUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("book not found by id: " + id)
        );

        bookUpdate.setName(book.getName());
        bookUpdate.setNum(book.getNum());
        bookUpdate.setWarehouse(book.getWarehouse());

        return repository.save(bookUpdate);

    }

    public List<String> nameAndPrice() {
        return repository.nameAndPrice();
    }

    public List<String> nameAndPriceMore20000() {
        return repository.nameAndPriceMore20000();
    }
}
