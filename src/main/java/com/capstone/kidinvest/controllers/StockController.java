package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.StockTransactionRepo;
import com.capstone.kidinvest.repositories.UserRepo;
import com.capstone.kidinvest.repositories.UserStockRepo;
import com.capstone.kidinvest.services.RestService;
import org.decimal4j.util.DoubleRounder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    private StockTransactionRepo stockTransactionDao;

    public StockController(StockRepo stockDao, UserRepo userDao, UserStockRepo userStockDao, StockTransactionRepo stockTransactionDao) {
        this.stockDao = stockDao;
        this.userDao = userDao;
        this.userStockDao = userStockDao;
        this.stockTransactionDao = stockTransactionDao;
    }

    @GetMapping("/stocks")
    public String viewStockPage(Model view, @RequestParam(value = "ticker", defaultValue = "FFS") String ticker) {
        RestService restService = new RestService(new RestTemplateBuilder());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
        List<UserStock> userStockList = userStockDao.findUserStockByUserId(user.getId());
        List<Stock> retrievedStockList = restService.retrieveStockData(restService.getStocksPlainJSON());
        UserStock currentUserStock = null;
        List<Stock> stockList = stockDao.findAll();
        Stock currentStock = null;
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        // Set all the updated stock info to our stockList that will be used to update the database
        for (int i = 0; i < stockList.size(); i++) {
            stockList.get(i).setMarketPrice(retrievedStockList.get(i).getMarketPrice());
            stockList.get(i).setOpenPrice(retrievedStockList.get(i).getOpenPrice());
            stockList.get(i).setLowPrice(retrievedStockList.get(i).getLowPrice());
            stockList.get(i).setHighPrice(retrievedStockList.get(i).getHighPrice());
//            stockList.get(i).setYearLowPrice(retrievedStockList.get(i).getYearLowPrice());
//            stockList.get(i).setYearHighPrice(retrievedStockList.get(i).getYearHighPrice());
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
        currentUserStock = userStockDao.findUserStockByStockIdAndUserId(currentStock.getId(), dbUser.getId());

        // check if first time viewer on stock page, if first time, then display the tutorial and flag that he is not a first time viewer.
        if (!dbUser.isViewedStocks()) {
            view.addAttribute("firstTime", true);
            dbUser.setViewedStocks(true);
            userDao.save(dbUser);
        }


        view.addAttribute("currentUserStock", currentUserStock);
        view.addAttribute("user", dbUser);
        view.addAttribute("currentStock", currentStock);
        view.addAttribute("userStocks", userStockList);
        view.addAttribute("stocks", stockList);
        return "stock/stock";
    }


    @PostMapping(value = "/stocks")
    public String buyStockButton(@RequestParam long stockShares,
                                 @RequestParam(value = "ticker", defaultValue = "FFS") String ticker,
                                 @RequestParam String currentStock_total,
                                 @RequestParam String stockAction) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User dbUser = userDao.findUserById(user.getId());
//        Stock stock = stockDao.findStockByTicker(ticker);
        List<UserStock> userStockList = userStockDao.findUserStockByUserId(user.getId());
        Stock selectedStock = stockDao.findStockByTicker(ticker);
        Timestamp time = new Timestamp(new java.util.Date().getTime());
        for (UserStock userStock : userStockList) {
            if (userStock.getStock().getTicker().equalsIgnoreCase(ticker)) {

                if (stockAction.equalsIgnoreCase("sell")) {
                    userStock.setShares(userStock.getShares() - stockShares);
                    // if user sells all their shares, reset the avg purchase price
                    if (userStock.getShares() == 0) {
                        userStock.setAvg_purchase_price(0);
                    }
                } else {
                    double newAvgPurchasePrice = this.calculateAveragePurchasePrice(userStock.getStock().getId(), dbUser.getId(), stockShares, userStock.getStock().getMarketPrice());
                    userStock.setAvg_purchase_price(newAvgPurchasePrice);
                    userStock.setShares(userStock.getShares() + stockShares);
                }
                userStockDao.save(userStock);
            }
        }
        // CHECKS FOR THE CORRESPONDING stockAction BUY/SELL
        if (stockAction.equalsIgnoreCase("buy")) {
            //CHECKS IF USER HAS ENOUGH AND MAKES PURCHASE
            if (dbUser.getBalance() >= Double.parseDouble(currentStock_total)) {
                dbUser.setBalance(dbUser.getBalance() - Double.parseDouble(currentStock_total));
                //   Save user's balance
                userDao.save(dbUser);
                // Update the stock transactions table
                stockTransactionDao.save(new StockTransaction(dbUser, selectedStock, stockShares, selectedStock.getMarketPrice(), time));
            }
        } else {
            // stockAction "SELL" AND UPDATES USERS BALANCE
            dbUser.setBalance(dbUser.getBalance() + Double.parseDouble(currentStock_total));
            //   Save user's balance
            userDao.save(dbUser);
            stockTransactionDao.save(new StockTransaction(dbUser, selectedStock, -stockShares, selectedStock.getMarketPrice(), time));
        }


        return "redirect:/stocks?ticker=" + ticker;
    }

    private double calculateAveragePurchasePrice(long stockId, long userId, long purchaseShares, double marketPrice) {
        UserStock userStock = userStockDao.findUserStockByStockIdAndUserId(stockId, userId);
        // if you do not have any shares, then the average price is equal to the market price
        if (userStock.getShares() == 0) {
            return userStock.getStock().getMarketPrice();
        }
        else {
            // calculate current total shares w/ their average purchase price
            double oldTotal = userStock.getShares() * userStock.getAvg_purchase_price();
            double newTotal = purchaseShares * marketPrice;
            return (oldTotal + newTotal) / (userStock.getShares() + purchaseShares);
        }
    }
}
