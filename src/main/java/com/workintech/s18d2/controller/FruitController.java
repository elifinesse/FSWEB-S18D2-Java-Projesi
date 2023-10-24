package com.workintech.s18d2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;

import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/fruit")
public class FruitController {
    
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> findPriceAscending(){
        return fruitService.findPriceAscending();
    }

    @GetMapping("/desc")
    public List<Fruit> findPriceDescending(){
        return fruitService.findPriceDescending();
    }

    @GetMapping("/{id}")
    public Fruit findById(@Positive @PathVariable int id){
        return fruitService.findById(id);
    }

    @PostMapping("/{name}")
    public List<Fruit> findByName(@PathVariable String name){
        return fruitService.findByName(name);
    }

    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("{id}")
    public Fruit delete(@Positive @PathVariable int id){
        return fruitService.delete(id);
    }    
}
