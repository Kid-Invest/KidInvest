package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.StockTransactionRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StockController {

    private StockRepo stockDao;
    private StockTransactionRepo stockTransactionDao;

    public StockController(StockRepo stockDao, StockTransactionRepo stockTransactionDao) {
        this.stockDao = stockDao;
        this.stockTransactionDao = stockTransactionDao;
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

    @GetMapping("/stocks/transactions/{id}")
    public String viewStockTransactionPage(Model view, @PathVariable Long id) {
        List<StockTransaction> stockTransactionsList = stockTransactionDao.findStockTransactionByUserId(id);

//        for (StockTransaction stockTransaction : stockTransactionsList) {
//            System.out.println(stockTransaction.getUser().getUsername());
//            System.out.println(stockTransaction.getStock().getName());
//            System.out.println(stockTransaction.getSharesBoughtSold());
//            System.out.println(stockTransaction.getPrice());
//            System.out.println(stockTransaction.getTime());
//        }
        view.addAttribute("stockTransactions", stockTransactionsList);
        return "stock/transactions";
    }


}
