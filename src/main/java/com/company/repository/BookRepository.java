package com.company.repository;

import com.company.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT DISTINCT name, price FROM books", nativeQuery = true)
    List<String> nameAndPrice();

    @Query(value = "SELECT name, price FROM books WHERE name LIKE '%Windows%' OR price >= 20000", nativeQuery = true)
    List<String> nameAndPriceMore20000();


}
