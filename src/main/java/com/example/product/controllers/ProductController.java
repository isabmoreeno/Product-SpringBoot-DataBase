package com.example.product.controllers;

import java.util.List;
import java.util.Optional;
import com.example.product.entities.Product;
import com.example.product.repositories.ProductRepository;
import com.example.product.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//chamadas http do Angular

@RestController
@RequestMapping("products")

public class ProductController {

    @Autowired
    private ProductService service;
    
    @GetMapping
    public List<Product> getProducts(){
        return service.getAllProducts();
    }

  @GetMapping("{id}")
    public Product getProductById(@PathVariable long id) {
        return service.getProductById(id);
    }
    
}

