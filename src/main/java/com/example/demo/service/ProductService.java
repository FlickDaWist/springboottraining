package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UpdateStockDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProductEntity> fetchAll(){
        return (List<ProductEntity>) repository.findAll();
    }

    public List<ProductEntity> fetch(long price){
        //if price set <= 0 return all the data without filter
        return price > 0 ? fetchByPriceUnder(price) : fetchAll();
    }

    public List<ProductEntity> fetchByPriceUnder(long price){
        return repository.findByPriceLessThanEqual(price);
    }

    public List<ProductEntity> fetchAllInStock(){
        return repository.findByStockGreaterThan(0);
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public ProductEntity getById(long id){
        return repository.findById(id).orElse(null);
    }

    public ProductEntity updateStock(UpdateStockDTO request){
        ProductEntity product = repository.findById(request.getId()).orElse(new ProductEntity());
        product.setStock(request.getStock() + product.getStock());
        return repository.save(product);
    }
}
