package com.company.controller;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Buy;
import com.company.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class BuyController {
    @Autowired
    BuyService service;

    @GetMapping("/buy")
    public List<Buy> getAllBooks() {
        return service.findAll();
    }

    @GetMapping("/buy/{id}")
    public Buy getBuy (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping("/buy")
    public Buy createBuy(@RequestBody Buy buy) {
        return service.save(buy);
    }

    @DeleteMapping("/buy/{id}")
    public Map<String, Boolean> deleteBuy(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return service.delete(id);
    }

    @PatchMapping("/buy/{id}")
    public Map<String, Boolean> updateBuy(@PathVariable(value = "id") Integer id, @RequestBody Buy buy) throws ResourceNotFoundException {
        return service.update(id,buy);
    }

    @PutMapping("/buy/{id}")
    public Buy fullUpdate(@RequestBody Buy buy, @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        return service.fullUpdate(id, buy);
    }

    @GetMapping("buy/diff-months")
    public List<String> getDifferentMonths() {
        return service.getDifferentMonths();
    }

    @GetMapping("buy/surname-storename")
    public List<String> getSurnameAndShop() {
        return service.getSurnameAndShop();
    }

    @GetMapping("buy/date-surname-discount")
    public List<String> getDateSurnameDiscountBookNameNum() {
        return service.getDateSurnameDiscountBookNameNum();
    }

    @GetMapping("buy/buy-more-60000")
    public List<String> getBuySumMore60000() {
        return service.getBuySumMore60000();
    }

    @GetMapping("buy/buy-in-customer-area")
    public List<String> getBuyInCustomerArea() {
        return service.getBuyInCustomerArea();
    }

    @GetMapping("buy/store-not-in-avtozavod")
    public List<String> getStoreNotInAvtozAndDiscountFrom10To15() {
        return service.getStoreNotInAvtozAndDiscountFrom10To15();
    }

    @GetMapping("buy/book-buy-details")
    public List<String> getBookBuyDetails() {
        return service.getBookBuyDetails();
    }

}
