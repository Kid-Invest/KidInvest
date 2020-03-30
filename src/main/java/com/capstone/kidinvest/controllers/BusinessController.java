package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.repositories.BusinessRepo;
import com.capstone.kidinvest.repositories.InventoryRepo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BusinessController {

    private BusinessRepo businessDao;
    private InventoryRepo inventoryDao;

    public BusinessController(BusinessRepo businessDao, InventoryRepo inventoryDao) {
        this.businessDao = businessDao;
        this.inventoryDao = inventoryDao;
    }

    @GetMapping("/business")
    public String index(Model model) {
        model.addAttribute("inventory", inventoryDao.findAll());
        return "business/index";
    }



    //transactions list
    //sample template to get business transactions listed
    //display addons
    //update addons
}
