package com.workintech.s18d2.services;

import java.util.List;

import com.workintech.s18d2.entity.Fruit;

public interface FruitService {

    Fruit findById(int id);
    Fruit save(Fruit fruit);
    Fruit delete(int id);
    List<Fruit> findPriceAscending();
    List<Fruit> findPriceDescending();
    List<Fruit> findByName(String name);
    
}
