package com.example.product.controllers;

import java.util.List;
import com.example.product.entities.Product;
import com.example.product.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//chamadas http do Angular

@RestController
@RequestMapping("products")

public class ProductController {

    @Autowired
    private ProductRepository repository;
    
    @GetMapping
    public List<Product> getProducts(){
        return repository.findAll();
    }
    }

