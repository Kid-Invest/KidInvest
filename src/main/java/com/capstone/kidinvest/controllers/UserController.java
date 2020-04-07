package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.*;
import com.capstone.kidinvest.repositories.*;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

//@ComponentScan("com.capstone.kidinvest")
@Controller
public class UserController {

    private UserRepo userDao;
    private UserStockRepo userStockDao;
    private BusinessRepo businessDao;
    private StockRepo stockDao;
    private IngredientRepo ingredientDao;
    private InventoryRepo inventoryDao;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepo userDao, UserStockRepo userStockDao, BusinessRepo businessDao, StockRepo stockDao, IngredientRepo ingredientDao, InventoryRepo inventoryDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.userStockDao = userStockDao;
        this.businessDao = businessDao;
        this.stockDao = stockDao;
        this.ingredientDao = ingredientDao;
        this.inventoryDao = inventoryDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String viewRegistrationPage(Model view) {
        view.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String doRegistration(@ModelAttribute User user) {
        // Create user based on informaiton provided
        String hash = passwordEncoder.encode(user.getPassword());
        user.setBalance(10000.00);
        user.setPassword(hash);
        userDao.save(user);
        // Create the business based off the username provided
        Business newBusiness = new Business(String.format("%s's Lemonade Stand", user.getUsername()), 0, user);
        businessDao.save(newBusiness);
        // Create initial inventory
        List<Ingredient> ingredientList = ingredientDao.findAll();
        Inventory newInventory = null;
        for (Ingredient ingredient : ingredientList) {
            newInventory = new Inventory(newBusiness, ingredient, 0);
            inventoryDao.save(newInventory);
        }
        // Create initial stocks
        List<Stock> stockList = stockDao.findAll();
        UserStock newUserStock = null;
        for (Stock stock : stockList) {
            newUserStock = new UserStock(user, stock, 0);
            userStockDao.save(newUserStock);
        }
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String viewUserStock(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        List<UserStock> userStockList = userStockDao.findUserStockByUserId(dbUser.getId());
        long portfolioValue = 0;
        for (UserStock userStock : userStockList) {
            portfolioValue += (userStock.getStock().getMarketPrice() * userStock.getShares());
        }

        view.addAttribute("portfolioValue", portfolioValue);
        view.addAttribute("userStocks", userStockList);
        view.addAttribute("user", dbUser);
        return "user/profile";
    }

    @GetMapping("/profile/leaderboard")
    public String viewLeaderboard(Model view){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        List<UserStock> dbUserStockList = userStockDao.findUserStockByUserId(dbUser.getId());
        List<User> userList = userDao.findAll();
        //create hashmap
        HashMap<Long, Double> userHash = new HashMap<>();
        for(int i = 1; i < userList.size(); i++){
            User eachUser = userDao.findUserById(i);
            List<UserStock> userStockList = userStockDao.findUserStockByUserId(i);
            double stockValuation = 0;
            for (UserStock userStock : userStockList) {
                stockValuation += (userStock.getStock().getMarketPrice() * userStock.getShares());
            }
            //add balance
            double portfolioValue = stockValuation + eachUser.getBalance();

            //pass info into hashmap
            userHash.putIfAbsent(eachUser.getId(), portfolioValue);
//            view.addAttribute("eachUser", eachUser);
//            view.addAttribute("portfolioValue", portfolioValue);
//            view.addAttribute("userStocks", userStockList);
        };
        view.addAttribute("dbUser", dbUser);
//        view.addAttribute("users", userList);
        //access hashmap
        view.addAttribute("users", userHash);
        return "user/leaderboard";
    }

}
