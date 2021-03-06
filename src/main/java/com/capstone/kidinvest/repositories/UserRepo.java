package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserById(long id);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}
