package com.example.product.mappers;

import com.example.product.entities.Product;
import com.example.product.dtos.ProductRequest;;

public class ProductMapper {
    
    public static Product toEntity(ProductRequest request) {
        Product p = new Product();
        p.setName(request.name());
        p.setPrice(request.price());
        return p;
    }

}
