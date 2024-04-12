package com.microservice.project.Inventoryservice.service;

import com.microservice.project.Inventoryservice.Repository.InventoryRepo;
import com.microservice.project.Inventoryservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;
    @Transactional(readOnly = true)
    public boolean isInStick(String skuCode){
         Inventory inventory = inventoryRepo.findBySkuCode(skuCode);
         if(inventory.getQuantity() > 0){
             return true;
         }
         return false;
    }

}
