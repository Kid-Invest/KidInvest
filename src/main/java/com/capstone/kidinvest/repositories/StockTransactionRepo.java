package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransactionRepo extends JpaRepository<StockTransaction, Long> {
}
