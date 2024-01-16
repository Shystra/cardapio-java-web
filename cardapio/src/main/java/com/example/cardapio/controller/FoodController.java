package com.example.cardapio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;

import java.util.List;


@RestController
@RequestMapping("postgres")
public class FoodController {
    
    @Autowired
    private FoodRepository repository;
    
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        //Criar um novo cardápio de alimentos no banco de dados
        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        
        return foodList;
    }
}
