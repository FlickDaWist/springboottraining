package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductEntity add(ProductDTO request){
        ProductEntity product = new ProductEntity();
        product.setProductName(request.getProductName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        repository.save(product);
        return product;
    }
}
