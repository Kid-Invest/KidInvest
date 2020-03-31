package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.BusinessTransactions;
import com.capstone.kidinvest.models.Inventory;
import com.capstone.kidinvest.models.Sale;
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

    private SaleRepo saleDao;

    public TransactionsController(BusinessRepo businessDao, BusinessTransactionsRepo businessTransactionsDao, StockRepo stockDao, StockTransactionRepo stockTransactionDao, SaleRepo saleDao) {
        this.businessDao = businessDao;
        this.businessTransactionsDao = businessTransactionsDao;
        this.stockDao = stockDao;
        this.stockTransactionDao = stockTransactionDao;
        this.saleDao = saleDao;
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
    public String viewBusinessTransactionsPage(Model view, @PathVariable long id) {
        List<BusinessTransactions> businessTransactionsList = businessTransactionsDao.findBusinessTransactionsByBusinessId(id);

        view.addAttribute("businessTransactions", businessTransactionsList);
        return "business/transactions";
    }

    @GetMapping("/sales/business/{id}")
    public String viewBusinessSalesPage(Model view, @PathVariable long id) {
        List<Sale> salesList = saleDao.findSaleByBusinessId(id);

        for(Sale sale : salesList){
            System.out.println(sale.getProfit());
            System.out.println(sale.getSaleDate());
        };

        view.addAttribute("sale", salesList);
        return "business/sales";
    }
}
