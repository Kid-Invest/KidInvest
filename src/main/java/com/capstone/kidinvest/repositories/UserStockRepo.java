package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserStockRepo extends JpaRepository<UserStock, Long> {
}
