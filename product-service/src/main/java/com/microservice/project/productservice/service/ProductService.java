package com.microservice.project.productservice.service;

import com.microservice.project.productservice.beans.Product;
import com.microservice.project.productservice.dto.ProductRequest;
import com.microservice.project.productservice.dto.ProductResponse;
import com.microservice.project.productservice.repository.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest){
        Product product = new Product();
        BeanUtils.copyProperties(productRequest,product);
        if(productRepo != null){
           product = productRepo.save(product);
        }
        System.out.println("Product is save : = "+ product.getId());
    }

    public List<ProductResponse> findAll() {
        List<Product> productList = productRepo.findAll();

        return productList.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }
}
