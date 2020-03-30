package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Business, Long> {
}
