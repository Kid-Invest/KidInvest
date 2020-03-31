package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.BusinessTransactions;
import com.capstone.kidinvest.models.Inventory;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionsController {
    private BusinessRepo businessDao;
    private BusinessTransactionsRepo businessTransactionsDao;

    private StockRepo stockDao;
    private StockTransactionRepo stockTransactionDao;

    public TransactionsController(BusinessRepo businessDao, BusinessTransactionsRepo businessTransactionsDao, StockRepo stockDao, StockTransactionRepo stockTransactionDao) {
        this.businessDao = businessDao;
        this.businessTransactionsDao = businessTransactionsDao;
        this.stockDao = stockDao;
        this.stockTransactionDao = stockTransactionDao;
    }

    @GetMapping("/transactions/stock/{id}")
    public String viewStockTransactionPage(Model view, @PathVariable long id) {
        List<StockTransaction> stockTransactionsList = stockTransactionDao.findStockTransactionsByUserId(id);

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

    @GetMapping("/transactions/business/{id}")
    public String viewBusinessPage(Model view, @PathVariable long id) {
        List<BusinessTransactions> businessTransactionsList = businessTransactionsDao.findBusinessTransactionsByBusinessId(id);

        view.addAttribute("businessTransactions", businessTransactionsList);
        return "business/transactions";
    }
}
