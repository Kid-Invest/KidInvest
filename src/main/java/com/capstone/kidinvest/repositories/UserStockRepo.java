package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserStockRepo extends JpaRepository<UserStock, Long> {
    List<UserStock> findUserStockByUserId(long userId);
}
