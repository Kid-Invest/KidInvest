package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Business;
import com.capstone.kidinvest.models.BusinessTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessTransactionsRepo extends JpaRepository<BusinessTransactions, Business> {
}
