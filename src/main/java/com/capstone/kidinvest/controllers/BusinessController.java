package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Addon;
import com.capstone.kidinvest.models.Ingredient;
import com.capstone.kidinvest.models.Inventory;
import com.capstone.kidinvest.repositories.AddonRepo;
import com.capstone.kidinvest.repositories.BusinessRepo;
import com.capstone.kidinvest.repositories.IngredientRepo;
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
    private IngredientRepo ingredientDao;
    private AddonRepo addonDao;

    public BusinessController(BusinessRepo businessDao, InventoryRepo inventoryDao, IngredientRepo ingredientDao, AddonRepo addonDao) {
        this.businessDao = businessDao;
        this.inventoryDao = inventoryDao;
        this.ingredientDao = ingredientDao;
        this.addonDao = addonDao;
    }

    @GetMapping("/business/{id}")
    public String viewBusinessPage(Model view, @PathVariable long id) {
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(id);

        view.addAttribute("inventory", inventoryList);
        return "business/business";
    }

    @GetMapping("/business/grocery-store")
    public String viewPurchasesPage(Model view) {
        List<Ingredient> ingredientList = ingredientDao.findAll();
        view.addAttribute("ingredients", ingredientList);
        return "business/grocery-store";
    }

    @GetMapping("/business/addon")
    public String viewAddonsPage(Model view) {
        List<Addon> addonList = addonDao.findAll();
        view.addAttribute("addons", addonList);
        return "business/addons";
    }

}
