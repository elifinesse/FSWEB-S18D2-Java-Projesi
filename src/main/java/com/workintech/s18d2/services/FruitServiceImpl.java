package com.workintech.s18d2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.workintech.s18d2.doa.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit findById(int id) {
        Optional<Fruit> optFruit = fruitRepository.findById(id);
        if(optFruit.isPresent()){
            return optFruit.get();
        }
        throw new PlantException("Fruit with this id (" + id + ") does not exist.", HttpStatus.NOT_FOUND);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(int id) {
        Fruit fruit = findById(id);
        fruitRepository.deleteById(id);
        return fruit;
    }

    @Override
    public List<Fruit> findPriceAscending() {
        return fruitRepository.findPriceAscending();
    }

    @Override
    public List<Fruit> findPriceDescending() {
        return fruitRepository.findPriceDescending();
    }

    @Override
    public List<Fruit> findByName(String name) {
        return fruitRepository.findByName(name);
    }
    
}
