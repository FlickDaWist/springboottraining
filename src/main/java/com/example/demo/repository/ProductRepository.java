package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByStockGreaterThan(long jumlah);

    List<ProductEntity> findByPriceLessThanEqual(long price);
}
