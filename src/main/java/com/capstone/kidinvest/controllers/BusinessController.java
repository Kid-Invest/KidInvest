package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.repositories.BusinessRepo;

public class BusinessController {

    private BusinessRepo businessDao;

    public BusinessController(BusinessRepo businessDao) {
        this.businessDao = businessDao;
    }

}
