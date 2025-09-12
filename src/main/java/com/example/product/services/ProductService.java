package com.example.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entities.Product;
import com.example.product.repositories.ProductRepository;
import com.example.product.dtos.ProductRequest;
import com.example.product.mappers.ProductMapper;



import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(long id) {
        return repository.findById(id)
                         .orElseThrow( ()-> new EntityNotFoundException("Produto não cadastrado"));
 }

    public void deleteProductById(long id){
		if(repository.existsById(id))
		repository.deleteById(id);
		    else
			    throw new EntityNotFoundException("Produto não existe");

}

   public Product saveProduct(ProductRequest request){
        return repository.save(ProductMapper.toEntity(request));
  }
  
   public void updateProduct(ProductRequest request, long id)
   {
        Product aux = repository.getReferenceById(id);
        aux.setName(request.name());
        aux.setPrice(request.price());

        repository.save(aux);
   }

}