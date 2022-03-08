package com.example.demo.controller;

import com.example.demo.dto.CommonResponse;
import com.example.demo.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductController {

    @GetMapping("")
    public CommonResponse getProducts() {
        //TODO: Add code to get all product list here
        return new CommonResponse("Dummy Products");
    }

    @GetMapping("{id}")
    public CommonResponse getProduct(@PathVariable("id") String id) {
        //TODO: Add code to get product here
        return new CommonResponse("Dummy Product");
    }

    @PostMapping("")
    public CommonResponse addProduct(@RequestBody ProductDTO productDTO) {
        //TODO: Add code to post here

        return new CommonResponse("Successfully add new product");
    }

    @PutMapping("/stock")
    public CommonResponse updateStock() {
        //TODO: Add code to post here
        return new CommonResponse("Successfully update stock");
    }

    @DeleteMapping("{id}")
    public CommonResponse deleteProduct(@PathVariable("id") String id) {
        //TODO: Add code to get product list here
        return new CommonResponse("Successfully delete product");
    }
}
