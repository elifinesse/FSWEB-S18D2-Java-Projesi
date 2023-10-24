package com.workintech.s18d2.doa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.workintech.s18d2.entity.Fruit;

public interface FruitRepository {
     @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> findPriceAscending();

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> findPriceDescending();

    @Query("SELECT f FROM Fruit f WHERE f.name ilike %:name%")
    List<Fruit> findByName(String name);
}
