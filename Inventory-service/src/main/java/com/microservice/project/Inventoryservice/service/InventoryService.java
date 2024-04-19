package com.microservice.project.Inventoryservice.service;

import com.microservice.project.Inventoryservice.Repository.InventoryRepo;
import com.microservice.project.Inventoryservice.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    InventoryRepo inventoryRepo;
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStick(List<String> skuCodes){
         List<InventoryResponse> inventoryResponsesList = inventoryRepo.findBySkuCodeIn(skuCodes).stream()
                 .map(inventory1 -> {
                     InventoryResponse inventoryResponse = new InventoryResponse();
                     inventoryResponse.setSkuCode(inventory1.getSkuCode());
                     inventoryResponse.setInStock(inventory1.getQuantity() > 0);
                     return inventoryResponse;
                 }).collect(Collectors.toList());

         return inventoryResponsesList;
    }

}
