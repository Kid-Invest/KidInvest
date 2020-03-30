package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.LemonadeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LemonadeIngredientRepo extends JpaRepository<LemonadeIngredient, Long> {

    List<LemonadeIngredient> findLemonadeIngredientByLemonadeId(long lemonadeId);
}
