package com.workintech.s18d2.doa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workintech.s18d2.entity.Vegetable;

public interface VegetableRepository extends JpaRepository<Vegetable, Long>{
    
    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> findPriceAscending();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> findPriceDescending();

    @Query("SELECT v FROM Vegetable v WHERE v.name ilike %:name%")
    List<Vegetable> findByName(String name);
}
