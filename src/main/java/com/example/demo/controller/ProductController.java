package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.UpdateStockDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private  final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ProductEntity> getProducts(@RequestParam(value = "priceUnder", defaultValue = "0") String price) {
        //TODO: Add code to get all product list here
        return service.fetch(Long.parseLong(price));
    }

    @GetMapping("{id}")
    public ProductEntity getProduct(@PathVariable("id") String id) {
        //TODO: Add code to get product here
//        return null;
//        return new CommonResponse("Dummy Product");
        return service.getById(Long.parseLong(id));
    }

    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDTO productDTO) {
        //TODO: Add code to post here
        return service.add(productDTO);
    }

    @PutMapping("/stock")
    public ProductEntity updateStock(@RequestBody UpdateStockDTO stock) {
        //TODO: Add code to post here
        return service.updateStock(stock);
    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") String id) {
        //TODO: Add code to get product list here
        service.delete(Long.parseLong(id));
        return new CommonResponse("Successfully delete product");
    }
}
