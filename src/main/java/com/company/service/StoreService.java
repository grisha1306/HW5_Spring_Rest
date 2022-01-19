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

    public Map<String, Boolean> update(int id, Store store) throws ResourceNotFoundException {
        Store storePatch = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        if (store.getName() != null)
            storePatch.setName(store.getName());

        if (store.getArea() != null)
            storePatch.setArea(store.getArea());

        if (store.getCommission() != null)
            storePatch.setCommission(store.getCommission());

        repository.save(storePatch);

        Map<String, Boolean> response = new HashMap<>();

        response.put("patch update", true);

        return response;
    }

    public Store fullUpdate(int id, Store store) throws ResourceNotFoundException {
        Store storeUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("contact not found by id: " + id)
        );

        storeUpdate.setName(store.getName());
        storeUpdate.setArea(store.getArea());
        storeUpdate.setCommission(store.getCommission());

        return repository.save(storeUpdate);
    }

    public List<String> nameSormovoSovetskiy() {
        return repository.nameSormovoSovetskiy();
    }
}
