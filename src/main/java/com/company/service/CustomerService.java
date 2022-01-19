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
                () -> new ResourceNotFoundException("customer not found by id: " + id)
        );

        return repository.getById(id);
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Map<String,Boolean> delete(int id) throws ResourceNotFoundException {

        Customer customer = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("customer not found by id: " + id)
        );

        repository.delete(customer);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);

        return response;

    }

    public Map<String, Boolean> update(int id, Customer customer) throws ResourceNotFoundException {
        Customer customerPatch = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("customer not found by id: " + id)
        );

        if (customer.getSurname() != null)
            customerPatch.setSurname(customer.getSurname());

        if (customer.getArea() != null)
            customerPatch.setArea(customer.getArea());

        if (customer.getDiscount() != null)
            customerPatch.setDiscount(customer.getDiscount());

        repository.save(customerPatch);

        Map<String, Boolean> response = new HashMap<>();

        response.put("patch update", true);

        return response;
    }

    public Customer fullUpdate(int id, Customer customer) throws ResourceNotFoundException {
        Customer customerUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("customer not found by id: " + id)
        );

        customerUpdate.setSurname(customer.getSurname());
        customerUpdate.setArea(customer.getArea());
        customerUpdate.setDiscount(customer.getDiscount());

        return repository.save(customerUpdate);
    }

    public List<String> differentArea() {
        return repository.differentArea();
    }

    public List<String> surnameDiscountNizhegorodskiy() {
        return repository.surnameDiscountNizhegorodskiy();
    }
}

