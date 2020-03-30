package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Lemonade;
import com.capstone.kidinvest.models.LemonadeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LemonadeIngredientRepo extends JpaRepository<LemonadeIngredient, Lemonade> {
}
