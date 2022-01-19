package com.company.controller;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Customer;
import com.company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/customer")
    public List<Customer> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getBook (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/customer")
    public Customer createBook(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.delete(id);
    }

    @PatchMapping("/customer/{id}")
    public Map<String, Boolean> updateBook(@PathVariable(value = "id") Integer id, @RequestBody Customer customer) throws ResourceNotFoundException {
        return service.update(id, customer);
    }

    @PutMapping("/customer/{id}")
    public Customer fullUpdate(@PathVariable(value = "id") Integer id, @RequestBody Customer customer) throws ResourceNotFoundException {

        return service.fullUpdate(id, customer);
    }

    @GetMapping("/customer/different-area")
    public List<String> differentArea() {
        return service.differentArea();
    }

    @GetMapping("/customer/surname-discount-nizhegorodskiy")
    public List<String> surnameDiscountNizhegorodskiy() {
        return service.surnameDiscountNizhegorodskiy();
    }
}
