package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Business;
import com.capstone.kidinvest.models.Ingredient;
import com.capstone.kidinvest.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {
    List<Inventory> findInventoryByBusinessId(long businessId);

    Inventory getInventoryByBusinessIdAndIngredientId(long business_id, long ingredient_id);


    @Query(nativeQuery = true, value = "SELECT total FROM inventory WHERE business_id = ?1 && ingredient_id = ?2")
    long findTotalByBusinessIdAAndIngredientId(long business_id, long ingredient_id);

//    @Query(nativeQuery = true, value = "SELECT * FROM inventory WHERE business_id = ?1 && ingredient_id = ?2")
//    Inventory findInventoryByBusinessIdAndIngredientId(long business_id, long ingredient_id);
}
