package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.BusinessTransactions;
import com.capstone.kidinvest.repositories.BusinessRepo;
import com.capstone.kidinvest.repositories.BusinessTransactionsRepo;
import com.capstone.kidinvest.repositories.InventoryRepo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BusinessController {

    private BusinessRepo businessDao;
    private InventoryRepo inventoryDao;
    private BusinessTransactionsRepo businessTransactionsDao;

    public BusinessController(BusinessRepo businessDao, InventoryRepo inventoryDao, BusinessTransactionsRepo businessTransactionsDao) {
        this.businessDao = businessDao;
        this.inventoryDao = inventoryDao;
        this.businessTransactionsDao = businessTransactionsDao;
    }

    @GetMapping("/business")
    public String viewBusinessPage(Model view) {
        List<BusinessTransactions> businessTransactionsList = businessTransactionsDao.findAll();

        view.addAttribute("businessTransactions", businessTransactionsList);
        return "business/business";
    }

    //transactions list
    //sample template to get business transactions listed
    //display addons
    //update addons
}
