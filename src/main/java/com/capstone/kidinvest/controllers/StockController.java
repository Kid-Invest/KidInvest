package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.models.User;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.StockTransactionRepo;
import com.capstone.kidinvest.repositories.UserStockRepo;
import com.capstone.kidinvest.services.RestService;
import org.decimal4j.util.DoubleRounder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StockController {

    private StockRepo stockDao;
    private UserStockRepo userStockDao;

    public StockController(StockRepo stockDao, UserStockRepo userStockDao) {
        this.stockDao = stockDao;
        this.userStockDao = userStockDao;
    }

    @GetMapping("/stocks")
    public String viewStockPage(Model view) {
        RestService restService = new RestService(new RestTemplateBuilder());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<UserStock> userStockList = userStockDao.findUserStockByUserId(user.getId());
        List<Stock> retrievedStockList = restService.parseJSONString(restService.getStocksPlainJSON());
        List<Stock> stockList = stockDao.findAll();
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
            stock.setChange(DoubleRounder.round(((1 - (stock.getOpenPrice() / stock.getMarketPrice())) * 100), 2));
            stockDao.save(stock);
        }
        view.addAttribute("userStocks", userStockList);
        view.addAttribute("stocks", stockList);
        return "stock/stock";
    }
}
