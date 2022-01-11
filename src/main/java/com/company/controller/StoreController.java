package com.company.controller;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Book;
import com.company.model.Store;
import com.company.repository.StoreRepository;
import com.company.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class StoreController {

    @Autowired
    StoreService service;

    @GetMapping("/store")
    public List<Store> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/store/{id}")
    public Store getBook (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/store")
    public Store createBook(@RequestBody Store store) {
        return service.save(store);
    }

    @DeleteMapping("/store/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.delete(id);
    }

    @PatchMapping("/store/{id}/{name}")
    public Map<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @PathVariable(value = "name") String name) throws ResourceNotFoundException {
        return service.update(id,name);
    }

    @PutMapping("/store/{id}")
    public Store fullUpdate(@RequestBody Store store) {

        return service.fullUpdate(store);
    }
}
