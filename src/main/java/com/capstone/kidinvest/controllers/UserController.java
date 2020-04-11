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

import java.util.*;

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
        System.out.println("SELECTED ID: " + user.getCharacterId());

        String hash = passwordEncoder.encode(user.getPassword());
        user.setBalance(10000.00);
        user.setPassword(hash);
        user.setTakenBusinessQuiz(false);
        user.setTakenStockQuiz(false);
        user.setViewedPortfolio(false);
        user.setViewedStocks(false);
        user.setViewedTransactions(false);
        user.setViewedStand(false);
        user.setViewedStore(false);
        userDao.save(user);
        // Create the business based off the username provided
        Business newBusiness = new Business(String.format("%s's Lemonade Stand", user.getUsername()), 0, user);
        businessDao.save(newBusiness);
        // Create initial inventory
        List<Ingredient> ingredientList = ingredientDao.findAll();
        Inventory newInventory = null;
        for (Ingredient ingredient : ingredientList) {
            newInventory = new Inventory(newBusiness, ingredient, 25);
            inventoryDao.save(newInventory);
        }
        // Create initial stocks
        List<Stock> stockList = stockDao.findAll();
        UserStock newUserStock = null;
        for (Stock stock : stockList) {
            newUserStock = new UserStock(user, stock, 0, 0);
            userStockDao.save(newUserStock);
        }
        return "redirect:/login";
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

//    public static void main(String[] args) {
//        UserController userController = new UserController();
//        List<UserStock> dbUserStockList = userStockDao.findUserStockByUserId(1);
//    }

    @GetMapping("/profile/leaderboard")
    public String viewLeaderboard(Model view){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        List<UserStock> dbUserStockList = userStockDao.findUserStockByUserId(dbUser.getId());
        List<User> userList = userDao.findAll();
        //create hashmap
        HashMap<String, Double> userMap = new HashMap<>();
        //loop through all users
        for(int i = 1; i < userList.size() + 1; i++){
            System.out.println(i);
            User eachUser = userDao.findUserById(i);
            List<UserStock> userStockList = userStockDao.findUserStockByUserId(i);
            double stockValuation = 0;
            for (UserStock userStock : userStockList) {
                System.out.println(userStock.getUser().getUsername());
                System.out.println(userStock.getStock().getTicker());
                stockValuation += (userStock.getStock().getMarketPrice() * userStock.getShares());
            }
            //add balance
            double portfolioValue = stockValuation + eachUser.getBalance();
            //pass info into hashmap
             String mappedName = eachUser.getUsername();
            userMap.putIfAbsent(mappedName, portfolioValue);
        };
        //create list from elements of hashmap before sorting
        List<HashMap.Entry<String, Double>> hmapList = new LinkedList<HashMap.Entry<String, Double>>(userMap.entrySet());
        //sort the list
        Collections.sort(hmapList, new Comparator<HashMap.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        //put sorted data back into hashmap
        HashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        userMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        view.addAttribute("dbUser", dbUser);
        //access sorted hashmap
        view.addAttribute("sortedMap", sortedMap);
        return "user/leaderboard";
    }

}
