package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.StockTransactionRepo;
import com.capstone.kidinvest.repositories.UserStockRepo;
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
        List<Stock> stockList = stockDao.findAll();

//        for (Stock stock : stockList) {
//            System.out.println(stock.getName());
//        }
        view.addAttribute("stocks", stockList);
        return "stock/stock";
    }

}
