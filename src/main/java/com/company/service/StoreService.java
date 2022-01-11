package com.company.service;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Store;
import com.company.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreService {
    @Autowired
    StoreRepository repository;

    public List<Store> findAll() {
        return repository.findAll();
    }

    public Store findById(int id) throws ResourceNotFoundException {
        Store store = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        return repository.getById(id);
    }

    public Store save(Store store) {
        return repository.save(store);
    }

    public Map<String,Boolean> delete(int id) throws ResourceNotFoundException {

        Store store = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        repository.delete(store);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);

        return response;

    }

    public Map<String, Boolean> update(int id, String name) throws ResourceNotFoundException {
        Store store = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        store.setName(name);

        Map<String, Boolean> response = new HashMap<>();

        response.put("patch update", true);

        return response;
    }

    public Store fullUpdate(Store store) {
        return repository.save(store);
    }
}