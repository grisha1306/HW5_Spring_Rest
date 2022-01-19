package com.company.repository;

import com.company.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query(value = "SELECT name FROM store s WHERE s.area = 'Sormovskiy' OR s.area = 'Sovetskiy'", nativeQuery = true)
    List<String> nameSormovoSovetskiy();

}
