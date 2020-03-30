package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Lemonade;
import com.capstone.kidinvest.models.LemonadeIngredient;
import com.capstone.kidinvest.repositories.IngredientRepo;
import com.capstone.kidinvest.repositories.InventoryRepo;
import com.capstone.kidinvest.repositories.LemonadeIngredientRepo;
import com.capstone.kidinvest.repositories.LemonadeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class LemonadeController {

    private IngredientRepo ingredientDao;
    private LemonadeRepo lemonadeDao;
    private LemonadeIngredientRepo lemonadeIngredientDao;
    private InventoryRepo inventoryDao;

    public LemonadeController(IngredientRepo ingredientDao, LemonadeRepo lemonadeDao, LemonadeIngredientRepo lemonadeIngredientDao, InventoryRepo inventoryDao) {
        this.ingredientDao = ingredientDao;
        this.lemonadeDao = lemonadeDao;
        this.lemonadeIngredientDao = lemonadeIngredientDao;
        this.inventoryDao = inventoryDao;
    }

    @GetMapping("/lemonade/{id}")
    public String viewLemonadePage(Model view, @PathVariable long id) {
        List<LemonadeIngredient> lemonadeIngredientList = lemonadeIngredientDao.findLemonadeIngredientByLemonadeId(id);
//        for (LemonadeIngredient item : lemonadeIngredientList) {
//            System.out.println(item.getLemonade().getName());
//            System.out.println(item.getIngredient().getName());
//            System.out.println(item.getCount());
//        }
        view.addAttribute("lemonadeIngredientList", lemonadeIngredientList);
        return "business/lemonade";
    }



}
