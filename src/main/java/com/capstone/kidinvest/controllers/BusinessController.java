package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Inventory;
import com.capstone.kidinvest.repositories.BusinessRepo;
import com.capstone.kidinvest.repositories.InventoryRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BusinessController {

    private BusinessRepo businessDao;
    private InventoryRepo inventoryDao;

    public BusinessController(BusinessRepo businessDao, InventoryRepo inventoryDao) {
        this.businessDao = businessDao;
        this.inventoryDao = inventoryDao;
    }

    @GetMapping("/business/{id}")
    public String viewBusinessPage(Model view, @PathVariable long id) {
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(id);

        view.addAttribute("inventory", inventoryList);
        return "business/business";
    }

    //sample template to get business transactions listed
    //display addons
    //update addons
}
