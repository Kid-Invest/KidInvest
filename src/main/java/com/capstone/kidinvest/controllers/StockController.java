package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.StockTransactionRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StockController {

    private StockRepo stockDao;

    public StockController(StockRepo stockDao) {
        this.stockDao = stockDao;
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
