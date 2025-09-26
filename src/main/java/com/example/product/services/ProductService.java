package com.example.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entities.Product;
import com.example.product.repositories.ProductRepository;
import com.example.product.dtos.ProductRequest;
import com.example.product.dtos.ProductResponse;
import com.example.product.mappers.ProductMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();

    }

    public ProductResponse getProductById(long id) {
        return repository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Produto não cadastrado"));
    }

    public void deleteProductById(long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Produto não existe");

    }

    public ProductResponse saveProduct(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        Product savedProduct = repository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    public void updateProduct(ProductRequest request, long id) {
        Product aux = repository.getReferenceById(id);
        aux.setName(request.name());
        aux.setPrice(request.price());

        repository.save(aux);
    }

}