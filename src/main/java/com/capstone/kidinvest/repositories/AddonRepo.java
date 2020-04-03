package com.capstone.kidinvest.repositories;

import com.capstone.kidinvest.models.Addon;
import com.capstone.kidinvest.models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddonRepo extends JpaRepository<Addon, Long> {

    Addon findAddonById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM addons AS a JOIN business_has_addons AS ba WHERE a.id = ba.addon_id && ba.business_id = ?1")
    List<Addon> findAddonsByBusinessId(long id);

    @Transactional
    @Modifying
    @Query(nativeQuery =  true, value = "INSERT INTO business_has_addons (business_id, addon_id) VALUES (:business_id, :addon_id)")
    void insertBusinessAddon(@Param("business_id") Business business, @Param("addon_id") Addon addon);

}
