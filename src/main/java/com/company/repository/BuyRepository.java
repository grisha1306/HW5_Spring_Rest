package com.company.repository;

import com.company.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buy, Integer> {

    @Query(value = "SELECT DISTINCT to_char(date_buy, 'month') FROM buy", nativeQuery = true)
    List<String> getDifferentMonths();

    @Query(value = "SELECT c.surname, s.name FROM buy b" +
            " INNER JOIN customer c on c.id = b.customer_id" +
            " INNER JOIN store s on s.id = b.store_id", nativeQuery = true)
    List<String> getSurnameAndShop();

    @Query(value = "SELECT b.date_buy, c.surname, c.discount, bk.name, b.num FROM buy b" +
            " INNER JOIN customer c on c.id = b.customer_id" +
            " INNER JOIN books bk on bk.id = b.book_id", nativeQuery = true)
    List<String> getDateSurnameDiscountBookNameNum();

    @Query(value = "SELECT b.order_number , c.surname, b.date_buy FROM buy b " +
            " INNER JOIN customer c on c.id = b.customer_id WHERE b.sum > 60000", nativeQuery = true)
    List<String> getBuySumMore60000();


    @Query(value = "SELECT c.surname, c.area, b.date_buy FROM buy b " +
            "INNER JOIN customer c on c.id = b.customer_id " +
            "INNER JOIN store s on s.id = b.store_id " +
            "WHERE c.area = s.area " +
            "AND EXTRACT (MONTH FROM date_buy) > 3 " +
            "ORDER BY date_buy", nativeQuery = true)
    List<String> getBuyInCustomerArea();


    @Query(value = "SELECT s.name, s.area FROM buy b " +
            "INNER JOIN store s on s.id = b.store_id " +
            "INNER JOIN customer c on c.id = b.customer_id " +
            "WHERE (c.discount >= 10 AND c.discount <= 15) AND s.area NOT LIKE 'Avtozavodskiy'", nativeQuery = true)
    List<String> getStoreNotInAvtozAndDiscountFrom10To15();

    @Query(value = "SELECT bk.name, bk.warehouse, bk.num, bk.price FROM buy b " +
            "INNER JOIN books bk on bk.id = b.book_id " +
            "INNER JOIN store s on s.id = b.store_id " +
            "WHERE s.area = bk.warehouse " +
            "AND bk.num >= 10 " +
            "ORDER BY bk.price", nativeQuery = true)
    List<String> getBookBuyDetails();
}
