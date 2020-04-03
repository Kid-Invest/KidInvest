package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.UserRepo;
import com.capstone.kidinvest.repositories.UserStockRepo;
import com.capstone.kidinvest.services.RestService;
import org.decimal4j.util.DoubleRounder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class StockController {

    private StockRepo stockDao;
    private UserRepo userDao;
    private UserStockRepo userStockDao;

    public StockController(StockRepo stockDao, UserRepo userDao, UserStockRepo userStockDao) {
        this.stockDao = stockDao;
        this.userDao = userDao;
        this.userStockDao = userStockDao;
    }

    @GetMapping("/stocks")
    public String viewStockPage(Model view, @RequestParam(value = "ticker", defaultValue = "FFS") String ticker) {
        RestService restService = new RestService(new RestTemplateBuilder());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<UserStock> userStockList = userStockDao.findUserStockByUserId(user.getId());
        List<Stock> retrievedStockList = restService.parseJSONString(restService.getStocksPlainJSON());
        List<Stock> stockList = stockDao.findAll();
        Stock currentStock = null;
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        // Set all the updated stock info to our stockList that will be used to update the database
        for(int i = 0; i < stockList.size(); i++){
            stockList.get(i).setMarketPrice(retrievedStockList.get(i).getMarketPrice());
            stockList.get(i).setOpenPrice(retrievedStockList.get(i).getOpenPrice());
            stockList.get(i).setLowPrice(retrievedStockList.get(i).getLowPrice());
            stockList.get(i).setHighPrice(retrievedStockList.get(i).getHighPrice());
            stockList.get(i).setYearLowPrice(retrievedStockList.get(i).getYearLowPrice());
            stockList.get(i).setYearHighPrice(retrievedStockList.get(i).getYearHighPrice());
        }
        // Determine the change percentage and then save/update all the stocks in the database
        for (Stock stock : stockList) {
            stock.setTime(time);
            stock.setChange(DoubleRounder.round(((1 - (stock.getOpenPrice() / stock.getMarketPrice())) * 100), 2));
            stockDao.save(stock);
        }
        if (ticker.equalsIgnoreCase("FFS")) {
            currentStock = stockDao.findStockById(1);
        } else {
            currentStock = stockDao.findStockByTicker(ticker);
        }

        view.addAttribute("user", userDao.findUserById(user.getId()));
        view.addAttribute("currentStock", currentStock);
        view.addAttribute("userStocks", userStockList);
        view.addAttribute("stocks", stockList);
        return "stock/stock";
    }



    @PostMapping(value = "/stocks")
    public String buyStockButton(@RequestParam long currentStockId, @RequestParam String total_purchase_cost) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());

        UserStock dbUserStock = userStockDao.findUserStockById(dbUser.getId());
        Stock stock = stockDao.findStockById(currentStockId);
//        UserStock usersStock = userStockDao.findUserStockByStock(stock);

        if (dbUser.getBalance() >= Double.parseDouble(total_purchase_cost)) { // change market_price to total
            dbUser.setBalance(dbUser.getBalance() - Double.parseDouble(total_purchase_cost));

            // Save user's balance
            userDao.save(dbUser);

            dbUserStock.setShares(dbUserStock.getShares() + currentStockId);
            userStockDao.save(dbUserStock);
        }
        return "redirect:stock/stock";
    }

}
