package com.project.microservices.OrderService.service;

import com.project.microservices.OrderService.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "inventory-service",url = "localhost:8082") //http://localhost:8082/
public interface OrderServiceProxy {

    @GetMapping("/api/inventory")
    public List<InventoryResponse> isInStock(@RequestParam("skuCode") List<String> skuCode);
}
