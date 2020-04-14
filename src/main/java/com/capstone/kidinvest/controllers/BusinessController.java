package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.*;
import com.capstone.kidinvest.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        User dbUser = userDao.findUserById(user.getId());
        Business userBusiness = businessDao.findBusinessById(user.getId());
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(userBusiness.getId());

        // check if first time viewer on stock page, if first time, then display the tutorial and flag that he is not a first time viewer.
        if (!dbUser.isViewedBusiness()) {
            view.addAttribute("firstTime", true);
            dbUser.setViewedBusiness(true);
            userDao.save(dbUser);
        }

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
        return "redirect:/business/addon";
    }

    @GetMapping("/business/grocery-store")
    public String viewGroceryStorePage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Business userBusiness = businessDao.findBusinessById(user.getId());
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(userBusiness.getId());
        List<Ingredient> ingredientList = ingredientDao.findAll();
        view.addAttribute("ingredients", ingredientList);
        view.addAttribute("inventoryList", inventoryList);
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
    public String viewOpenStorePage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        Business userBusiness = businessDao.findBusinessById(dbUser.getId());
        List<Inventory> inventoryList = inventoryDao.findInventoryByBusinessId(user.getId());
        List<Addon> businessAddonsList = addonDao.findAddonsByBusinessId(userBusiness.getId());
        int popularityBonus = 0;
        for (Addon addon : businessAddonsList) {
            popularityBonus += addon.getPopularityBonus();
        }
        view.addAttribute("spriteId", dbUser.getCharacterId());
        view.addAttribute("popBonus", popularityBonus);
        view.addAttribute("addonList", businessAddonsList);
        view.addAttribute("inventoryList", inventoryList);
        return "business/open-stand";
    }

    @PostMapping("/business/open-stand")
    public String doLemonadeSale(@RequestParam String earnings, @RequestParam String ingredient_id1, @RequestParam String ingredient_id2, @RequestParam String ingredient_id3, @RequestParam String ingredient_id4, @RequestParam String ingredient_id5, @RequestParam String ingredient_id6, @RequestParam String ingredient_id7, @RequestParam String ingredient_id8, @RequestParam String ingredient_id9) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        Business userBusiness = businessDao.findBusinessById(dbUser.getId());
//        Lemonade selectedLemonade = lemonadeDao.getOne(Long.parseLong(requested_lemonade_id));
        List<Integer> updatedInventoryList = new ArrayList<>();
        updatedInventoryList.add(Integer.parseInt(ingredient_id1));
        updatedInventoryList.add(Integer.parseInt(ingredient_id2));
        updatedInventoryList.add(Integer.parseInt(ingredient_id3));
        updatedInventoryList.add(Integer.parseInt(ingredient_id4));
        updatedInventoryList.add(Integer.parseInt(ingredient_id5));
        updatedInventoryList.add(Integer.parseInt(ingredient_id6));
        updatedInventoryList.add(Integer.parseInt(ingredient_id7));
        updatedInventoryList.add(Integer.parseInt(ingredient_id8));
        updatedInventoryList.add(Integer.parseInt(ingredient_id9));
        List<Inventory> userInventoryList = inventoryDao.findInventoryByBusinessId(userBusiness.getId());
        Date date = new Date(new java.util.Date().getTime());
        System.out.println("DATE HERE: " + date);
        System.out.println(earnings);
        Sale dailySales = saleDao.findSaleBySaleDateAndBusinessId(date, userBusiness.getId());
        System.out.println("SALES HERE: " + dailySales);

        // set the user's inventory to the new values from the game
        for (int i = 0; i < updatedInventoryList.size(); i++) {
            userInventoryList.get(i).setTotal(updatedInventoryList.get(i));
            inventoryDao.save(userInventoryList.get(i));
        }

//        System.out.println("LEMONS: " + ingredient_id1);
//        System.out.println("ICE: " + ingredient_id2);
//        System.out.println("SUGAR: " + ingredient_id3);
//        System.out.println("HONEY: " + ingredient_id4);
//        System.out.println("SWEETENER: " + ingredient_id5);
//        System.out.println("STRAWBERRY: " + ingredient_id6);
//        System.out.println("PEACH: " + ingredient_id7);
//        System.out.println("BLUEBERRY: " + ingredient_id8);
//        System.out.println("RASPBERRY: " + ingredient_id9);
//        System.out.println("TOTAL EARNINGS: " + earnings);

        // increase the user's balance based on the earnings
        dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(earnings));
        userDao.save(dbUser);

        // Insert a new sale into sales table
        if (dailySales != null) {
            saleDao.updateSale(dailySales.getProfit() + Double.parseDouble(earnings), date, userBusiness);
        } else {
            saleDao.insertSale(Double.parseDouble(earnings), date, userBusiness);
        }

        // Get list of ingredients and loop through and
//        List<LemonadeIngredient> lemonadeIngredientList = lemonadeIngredientDao.findLemonadeIngredientByLemonadeId(selectedLemonade.getId());
//        boolean enoughIngredients = hasEnoughIngredients(userBusiness, lemonadeIngredientList);
//        if (enoughIngredients) {
//            for (LemonadeIngredient lemonadeIngredient : lemonadeIngredientList) {
//                userInventoryItem = inventoryDao.getInventoryByBusinessIdAndIngredientId(userBusiness.getId(), lemonadeIngredient.getIngredient().getId());
//                userInventoryItem.setTotal(userInventoryItem.getTotal() - lemonadeIngredient.getCount());
//                inventoryDao.save(userInventoryItem);
//            }
//            // Increase balance based off sale
//            dbUser.setBalance(dbUser.getBalance() + selectedLemonade.getPrice());
//            // Save user's balance
//            userDao.save(dbUser);
//            // Insert a new sale into sales table
//            if (dailySales != null) {
//                saleDao.updateSale(dailySales.getProfit() + selectedLemonade.getPrice(), date, userBusiness);
//            } else {
//                saleDao.insertSale(selectedLemonade.getPrice(), date, userBusiness);
//            }
//            return "redirect:/business/open-stand";
//        } else {
//            return "redirect:/business/open-stand?missingIngredient=true";
//        }
        return "redirect:/business";
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
