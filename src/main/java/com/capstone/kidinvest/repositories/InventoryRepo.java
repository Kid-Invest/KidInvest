package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Business;
import com.capstone.kidinvest.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    Inventory findById(long id);
    Inventory findByTotal(long total);
    Inventory findByBusiness(Business business);
}
