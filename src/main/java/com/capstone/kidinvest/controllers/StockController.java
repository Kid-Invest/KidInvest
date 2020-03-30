package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.repositories.StockRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StockController {

    private StockRepo stockRepo;

    public StockController (StockRepo stockRepo) {
        this.stockRepo = stockRepo;
    }

    @GetMapping("/stocks")
    public String viewStockPage(Model view) {
        List<Stock> stockList = stockRepo.findAll();

        for (Stock stock : stockList) {
            System.out.println(stock.getName());
        }
        view.addAttribute("stocks", stockList);
        return "stock/stock";
    }


}
