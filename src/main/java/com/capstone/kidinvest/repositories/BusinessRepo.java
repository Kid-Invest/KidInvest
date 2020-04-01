package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Business;
import com.capstone.kidinvest.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessRepo extends JpaRepository<Business, Long> {
    //List<Sale> findbusinessSalesbyBusinessId(long id);
}
