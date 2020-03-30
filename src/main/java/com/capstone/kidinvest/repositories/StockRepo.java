package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Long> {
}
