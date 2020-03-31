package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockTransactionRepo extends JpaRepository<StockTransaction, Long> {
    List<StockTransaction> findStockTransactionsByUserId(long userId);
}
