package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UserStockRepo extends JpaRepository<UserStock, Long> {
    List<UserStock> findUserStockByUserId(long userId);

    @Query(nativeQuery = true, value = "SELECT * FROM user_has_stocks WHERE stock_id = ?1 && user_id = ?2")
    UserStock findUserStockByStockIdAndUserId (long stock, long user);


}
