package com.project.microservices.OrderService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service",url = "localhost:8082") //http://localhost:8082/
public interface OrderServiceProxy {

    @GetMapping("/api/inventory/{skuCode}")
    public boolean retriveProductStock(@PathVariable String skuCode);
}
