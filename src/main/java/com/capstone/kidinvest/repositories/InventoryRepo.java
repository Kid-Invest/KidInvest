package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Business;
import com.capstone.kidinvest.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    List<Inventory> findInventoryByBusinessId(long businessId);
    List<Inventory> findInventoryByIngredientId(long ingredientId);
}
