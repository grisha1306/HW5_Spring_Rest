package com.company.service;
import com.company.exception.ResourceNotFoundException;
import com.company.model.Customer;
import com.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(int id) throws ResourceNotFoundException {
        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        return repository.getById(id);
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Map<String,Boolean> delete(int id) throws ResourceNotFoundException {

        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        repository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);

        return response;

    }

    public Map<String, Boolean> update(int id, String name) throws ResourceNotFoundException {
        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        customer.setSurname(name);

        Map<String, Boolean> response = new HashMap<>();

        response.put("patch update", true);

        return response;
    }

    public Customer fullUpdate(Customer customer) {
        return repository.save(customer);
    }
}

