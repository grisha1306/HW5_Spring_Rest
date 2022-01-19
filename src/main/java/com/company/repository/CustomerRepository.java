package com.company.repository;

import com.company.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    @Query(value = "SELECT DISTINCT area FROM customer GROUP BY area", nativeQuery = true)
    List<String> differentArea();

    @Query(value = "SELECT surname, discount FROM customer c WHERE c.area = 'Nizhegorodskiy' ", nativeQuery = true)
    List<String> surnameDiscountNizhegorodskiy();
}
