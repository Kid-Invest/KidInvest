package com.capstone.kidinvest.repositories;


import com.capstone.kidinvest.models.BusinessTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessTransactionsRepo extends JpaRepository<BusinessTransactions,Long> {
    List<BusinessTransactions> findBusinessTransactionsByBusinessId(long businessId);
}
