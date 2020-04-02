package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Addon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddonRepo extends JpaRepository<Addon, Long> {
}
