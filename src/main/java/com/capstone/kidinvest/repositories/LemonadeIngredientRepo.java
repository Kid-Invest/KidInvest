package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.LemonadeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LemonadeIngredientRepo extends JpaRepository<LemonadeIngredient, Long> {
}
