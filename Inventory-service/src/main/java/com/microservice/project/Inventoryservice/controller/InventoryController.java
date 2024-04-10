package com.microservice.project.Inventoryservice.controller;

import com.microservice.project.Inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService ;

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable String skuCode){
        return inventoryService.isInStick(skuCode);
    }
}
