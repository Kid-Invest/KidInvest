package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.models.UserStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStockRepo extends JpaRepository<UserStock, User> {
}
