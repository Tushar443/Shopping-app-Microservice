package com.microservice.project.Inventoryservice.Repository;

import com.microservice.project.Inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {

    Optional<Inventory> findBySkuCode(String skuCOde);

}
