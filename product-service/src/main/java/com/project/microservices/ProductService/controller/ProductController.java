package com.project.microservices.ProductService.controller;

import com.project.microservices.ProductService.repository.dto.ProductRequest;
import com.project.microservices.ProductService.repository.dto.ProductResponse;
import com.project.microservices.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        List<ProductResponse> productResponses = productService.findAll();
        return productResponses;
    }
}
