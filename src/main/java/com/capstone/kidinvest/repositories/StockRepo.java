package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Long> {
    Stock findStockById(long stockId);
    Stock findStockByTicker(String ticker);
}
