package com.company.controller;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Store;
import com.company.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/store/{id}")
    public Map<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @RequestBody Store store) throws ResourceNotFoundException {
        return service.update(id,store);
    }

    @PutMapping("/store/{id}")
    public Store fullUpdate(@PathVariable(value = "id") Integer id, @RequestBody Store store) throws ResourceNotFoundException {

        return service.fullUpdate(id, store);
    }

    @GetMapping("/store/name-sormovo-sovetskiy")
    public List<String> nameSormovoSovetskiy() {
        return service.nameSormovoSovetskiy();
    }
}
