package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
