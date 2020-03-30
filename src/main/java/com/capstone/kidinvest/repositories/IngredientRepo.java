package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
