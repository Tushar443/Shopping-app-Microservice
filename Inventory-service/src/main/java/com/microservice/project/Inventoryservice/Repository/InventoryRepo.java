package com.microservice.project.Inventoryservice.Repository;

import com.microservice.project.Inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {

    Inventory findBySkuCode(String skuCOde);

}
