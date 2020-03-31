package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepo extends JpaRepository<Sale, Long> {
    List<Sale> findSaleByBusinessId(long businessId);
}
