package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Addon;
import com.capstone.kidinvest.models.Business;
import com.capstone.kidinvest.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface SaleRepo extends JpaRepository<Sale, Long> {
    List<Sale> findSaleByBusinessId(long businessId);

    @Query(nativeQuery = true, value = "SELECT * FROM sales WHERE sale_date = ?1 && business_id = ?2")
    Sale findSaleBySaleDateAndBusinessId(Date saleDate, long businessId);

    @Transactional
    @Modifying
    @Query(nativeQuery =  true, value = "INSERT INTO sales (profit, sale_date, business_id) VALUES (:profit, :sale_date, :business_id)")
    void insertSale(@Param("profit") double profit, @Param("sale_date") Date saleDate, @Param("business_id") Business business);

    @Transactional
    @Modifying
    @Query(nativeQuery =  true, value = "UPDATE sales SET profit = :profit WHERE business_id = :business_id && sale_date = :sale_date")
    void updateSale(@Param("profit") double profit, @Param("sale_date") Date saleDate, @Param("business_id") Business business);
}
