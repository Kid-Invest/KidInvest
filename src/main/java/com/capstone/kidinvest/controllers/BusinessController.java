package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Ingredient;
import com.capstone.kidinvest.models.Inventory;
import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.repositories.BusinessRepo;
import com.capstone.kidinvest.repositories.IngredientRepo;
import com.capstone.kidinvest.repositories.InventoryRepo;
import com.capstone.kidinvest.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BusinessController {

    private BusinessRepo businessDao;
    private InventoryRepo inventoryDao;
    private IngredientRepo ingredientDao;
    private UserRepo userDao;

    public BusinessController(BusinessRepo businessDao, InventoryRepo inventoryDao, IngredientRepo ingredientDao, UserRepo userDao) {
        this.businessDao = businessDao;
        this.inventoryDao = inventoryDao;
        this.ingredientDao = ingredientDao;
        this.userDao = userDao;
    }

    @GetMapping("/business")
    public String viewBusinessPage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(user.getId());
        view.addAttribute("inventory", inventoryList);
        return "business/business";
    }

    @GetMapping("/business/grocery-store")
    public String viewGroceryStorePage(Model view) {
        List<Ingredient> ingredientList = ingredientDao.findAll();
        view.addAttribute("ingredients", ingredientList);
        return "business/grocery-store";
    }

    @PostMapping("/business/grocery-store")
    public String doGroceryPurchase(@RequestParam String ingredient_id1, @RequestParam String ingredient_id2, @RequestParam String ingredient_id3, @RequestParam String ingredient_id4, @RequestParam String ingredient_id5, @RequestParam String ingredient_id6, @RequestParam String ingredient_id7, @RequestParam String ingredient_id8, @RequestParam String ingredient_id9, @RequestParam String total_purchase_cost) {

//        System.out.println("LEMONS: " + ingredient_id1);
//        System.out.println("ICE: " + ingredient_id2);
//        System.out.println("SUGAR: " + ingredient_id3);
//        System.out.println("HONEY: " + ingredient_id4);
//        System.out.println("SWEETENER: " + ingredient_id5);
//        System.out.println("STRAWBERRY: " + ingredient_id6);
//        System.out.println("PEACH: " + ingredient_id7);
//        System.out.println("BLUEBERRY: " + ingredient_id8);
//        System.out.println("RASPBERRY: " + ingredient_id9);
//        System.out.println("TOTAL COST: " + total_purchase_cost);
        // Subtract from user's balance
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(user.getId());
        boolean enoughMoney = false;
        if (dbUser.getBalance() >= Double.parseDouble(total_purchase_cost)) {
            dbUser.setBalance(dbUser.getBalance() - Double.parseDouble(total_purchase_cost));
            // Save dbUser's balance
            userDao.save(dbUser);
            // Loop through inventory and update inventory based on id
            for (Inventory inventory : inventoryList) {
                switch ((int)inventory.getIngredient().getId()) {
                    case 1:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id1));
                        break;
                    case 2:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id2));
                        break;
                    case 3:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id3));
                        break;
                    case 4:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id4));
                        break;
                    case 5:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id5));
                        break;
                    case 6:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id6));
                        break;
                    case 7:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id7));
                        break;
                    case 8:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id8));
                        break;
                    case 9:
                        inventory.setTotal(inventory.getTotal() + Long.parseLong(ingredient_id9));
                        break;
                }
                inventoryDao.save(inventory);
            }
        }
        return "redirect:/business";
    }
}
