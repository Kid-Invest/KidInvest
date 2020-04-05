package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.*;
import com.capstone.kidinvest.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class BusinessController {

    private BusinessRepo businessDao;
    private InventoryRepo inventoryDao;
    private IngredientRepo ingredientDao;
    private AddonRepo addonDao;
    private UserRepo userDao;
    private LemonadeRepo lemonadeDao;
    private LemonadeIngredientRepo lemonadeIngredientDao;
    private BusinessTransactionsRepo businessTransactionsDao;
    private SaleRepo saleDao;

    public BusinessController(BusinessRepo businessDao, InventoryRepo inventoryDao, IngredientRepo ingredientDao, LemonadeIngredientRepo lemonadeIngredientDao, AddonRepo addonDao, UserRepo userDao, LemonadeRepo lemonadeDao, BusinessTransactionsRepo businessTransactionsDao, SaleRepo saleDao) {
        this.businessDao = businessDao;
        this.inventoryDao = inventoryDao;
        this.ingredientDao = ingredientDao;
        this.addonDao = addonDao;
        this.userDao = userDao;
        this.lemonadeDao = lemonadeDao;
        this.lemonadeIngredientDao = lemonadeIngredientDao;
        this.businessTransactionsDao = businessTransactionsDao;
        this.saleDao = saleDao;
    }

    @GetMapping("/business")
    public String viewBusinessPage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(user.getId());
        view.addAttribute("inventoryList", inventoryList);
        return "business/business";
    }

    @GetMapping("/business/addon")
    public String viewAddonsPage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Business userBusiness = businessDao.findBusinessById(user.getId());
        List<Addon> addonList = addonDao.findAll();
        List<Addon> businessAddonList = addonDao.findAddonsByBusinessId(userBusiness.getId());
        view.addAttribute("businessAddons", businessAddonList);
        view.addAttribute("addons", addonList);
        return "business/addons";
    }

    @PostMapping("/business/addon")
    public String doAddonPurchase(@RequestParam long id) {
//        System.out.println("Candy Machine: " + addon_id1);
//        System.out.println("Radio: " + addon_id2);
//        System.out.println("Sign: " + addon_id3);
//        System.out.println("Cooler: " + addon_id4);
//        System.out.println("water filter machine: " + addon_id5);

        System.out.println(id);

        //List<Addon> addonList = addonDao.findAddonByBusinessId(1);
        // Subtract from user's balance
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        Business userBusiness = businessDao.findBusinessById(dbUser.getId());
        // Find out if user has the addon
        List<Addon> addonList = addonDao.findAddonsByBusinessId(userBusiness.getId());
        Addon selectedAddon = addonDao.findAddonById(id);
        boolean alreadyPurchased = false;
        for (Addon addon : addonList) {
            if (addon.getId() == id) {
                alreadyPurchased = true;
            }
            System.out.println("User already purchased: " + addon.getName());
        }

        // If it's not already purchased, then add to the table and deduct from the user's balance
        if (!alreadyPurchased) {
            if (dbUser.getBalance() >= selectedAddon.getPrice()) {
                dbUser.setBalance(dbUser.getBalance() - selectedAddon.getPrice());
                // Save user's balance
                addonDao.insertBusinessAddon(userBusiness, selectedAddon);
                userDao.save(dbUser);
            }
        }
        return "redirect:/business";
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
        Business dbUserBusiness = businessDao.findBusinessById(dbUser.getId());
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(dbUserBusiness.getId());
        Timestamp time = new Timestamp(new java.util.Date().getTime());

        boolean enoughMoney = false;
        if (dbUser.getBalance() >= Double.parseDouble(total_purchase_cost)) {
            dbUser.setBalance(dbUser.getBalance() - Double.parseDouble(total_purchase_cost));
            // Save dbUser's balance
            userDao.save(dbUser);
            // Loop through inventory and update inventory based on id
            long ingredientTotal;
            for (Inventory inventory : inventoryList) {
                ingredientTotal = 0;
                switch ((int) inventory.getIngredient().getId()) {
                    case 1:
                        ingredientTotal = Long.parseLong(ingredient_id1);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 2:
                        ingredientTotal = Long.parseLong(ingredient_id2);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 3:
                        ingredientTotal = Long.parseLong(ingredient_id3);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 4:
                        ingredientTotal = Long.parseLong(ingredient_id4);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 5:
                        ingredientTotal = Long.parseLong(ingredient_id5);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 6:
                        ingredientTotal = Long.parseLong(ingredient_id6);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 7:
                        ingredientTotal = Long.parseLong(ingredient_id7);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 8:
                        ingredientTotal = Long.parseLong(ingredient_id8);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                    case 9:
                        ingredientTotal = Long.parseLong(ingredient_id9);
                        inventory.setTotal(inventory.getTotal() + ingredientTotal);
                        break;
                }
                // Update's the transactions page
                if (ingredientTotal != 0) {
                    businessTransactionsDao.save(new BusinessTransactions(dbUserBusiness, inventory.getIngredient(), ingredientTotal, time));
                    inventoryDao.save(inventory);
                }
            }
        }
        return "redirect:/business";
    }

    @GetMapping("/business/open-stand")
    public String viewOpenStorePage(Model view, @RequestParam(value = "missingIngredient", defaultValue = "null") String missingIngredient) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(user.getId());

        view.addAttribute("missingIngredient", missingIngredient);
        view.addAttribute("inventoryList", inventoryList);
        return "business/open-stand";
    }

    @PostMapping("/business/open-stand")
    public String doLemonadeSale(@RequestParam String requested_lemonade_id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        Business userBusiness = businessDao.findBusinessById(dbUser.getId());
        Lemonade selectedLemonade = lemonadeDao.getOne(Long.parseLong(requested_lemonade_id));
        Inventory userInventoryItem = null;
        Date date = new Date(new java.util.Date().getTime());
        Sale dailySales = saleDao.findSaleBySaleDate(date);

        // Get list of ingredients and loop through and
        List<LemonadeIngredient> lemonadeIngredientList = lemonadeIngredientDao.findLemonadeIngredientByLemonadeId(selectedLemonade.getId());
        boolean enoughIngredients = hasEnoughIngredients(userBusiness, lemonadeIngredientList);
        if (enoughIngredients) {
            for (LemonadeIngredient lemonadeIngredient : lemonadeIngredientList) {
                userInventoryItem = inventoryDao.getInventoryByBusinessIdAndIngredientId(userBusiness.getId(), lemonadeIngredient.getIngredient().getId());
                userInventoryItem.setTotal(userInventoryItem.getTotal() - lemonadeIngredient.getCount());
                inventoryDao.save(userInventoryItem);
            }
            // Increase balance based off sale
            dbUser.setBalance(dbUser.getBalance() + selectedLemonade.getPrice());
            // Save user's balance
            userDao.save(dbUser);
            // Insert a new sale into sales table
            if (dailySales != null) {
                saleDao.updateSale(dailySales.getProfit() + selectedLemonade.getPrice(), date, userBusiness);
            } else {
                saleDao.insertSale(selectedLemonade.getPrice(), date, userBusiness);
            }
            return "redirect:/business/open-stand";
        } else {
            return "redirect:/business/open-stand?missingIngredient=true";
        }
    }

    private boolean hasEnoughIngredients(Business business, List<LemonadeIngredient> lemonadeIngredientList) {
        // Check to see if there's enough ingredients
        long totalIngredientsInInventory;
        for (LemonadeIngredient lemonadeIngredient : lemonadeIngredientList) {
            totalIngredientsInInventory = inventoryDao.findTotalByBusinessIdAAndIngredientId(business.getId(), lemonadeIngredient.getIngredient().getId());
            if (totalIngredientsInInventory < lemonadeIngredient.getCount()) {
                return false;
            }
        }
        return true;
    }

}
