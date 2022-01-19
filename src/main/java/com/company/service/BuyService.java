package com.company.service;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Buy;
import com.company.repository.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyService {

    @Autowired
    BuyRepository repository;

    public List<Buy> findAll() {
        return repository.findAll();
    }

    public Buy findById(int id) throws ResourceNotFoundException {
        Buy buy = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("buy not found by id: " + id)
        );

        return repository.getById(id);
    }

    public Buy save(Buy buy) {
        return repository.save(buy);
    }

    public Map<String,Boolean> delete (int id) throws ResourceNotFoundException {

        Buy buy = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("buy not found by id: " + id)
        );

        repository.delete(buy);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", true);

        return response;

    }

    public Map<String, Boolean> update(int id, Buy buy) throws ResourceNotFoundException {
        Buy patchBuy = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("buy not found by id: " + id)
        );

        if (buy.getDateBuy() != null)
            patchBuy.setDateBuy(buy.getDateBuy());

        if (buy.getBook() != null)
            patchBuy.setBook(buy.getBook());

        if (buy.getCustomer() != null)
            patchBuy.setCustomer(buy.getCustomer());

        if (buy.getStore() != null)
            patchBuy.setStore(buy.getStore());

        if (buy.getNum() != null)
            patchBuy.setNum(buy.getNum());

        if (buy.getSum() != null)
            patchBuy.setSum(buy.getSum());

        repository.save(patchBuy);

        Map<String, Boolean> response = new HashMap<>();

        response.put("patch update", true);

        return response;
    }

    public Buy fullUpdate(int id, Buy buy) throws ResourceNotFoundException {
        Buy buyUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("buy not found by id: " + id)
        );

        buyUpdate.setDateBuy(buy.getDateBuy());
        buyUpdate.setCustomer(buy.getCustomer());
        buyUpdate.setStore(buy.getStore());
        buyUpdate.setBook(buy.getBook());
        buyUpdate.setNum(buy.getNum());
        buyUpdate.setSum(buy.getSum());

        return repository.save(buyUpdate);

    }

    public List<String> getDifferentMonths() {
        return repository.getDifferentMonths();
    }

    public List<String> getSurnameAndShop() {
        return repository.getSurnameAndShop();
    }

    public List<String> getDateSurnameDiscountBookNameNum() {
        return repository.getDateSurnameDiscountBookNameNum();
    }

    public List<String> getBuySumMore60000() {
        return repository.getBuySumMore60000();
    }

    public List<String> getBuyInCustomerArea() {
        return repository.getBuyInCustomerArea();
    }

    public List<String> getStoreNotInAvtozAndDiscountFrom10To15() {return repository.getStoreNotInAvtozAndDiscountFrom10To15();}

    public List<String> getBookBuyDetails() {return repository.getBookBuyDetails();}

}
