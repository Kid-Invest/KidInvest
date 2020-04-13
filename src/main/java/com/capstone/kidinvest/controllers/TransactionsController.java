package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.*;
import com.capstone.kidinvest.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/transactions/stock")
    public String viewStockTransactionPage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<StockTransaction> stockTransactionsList = stockTransactionDao.findStockTransactionsByUserId(user.getId());

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

    @GetMapping("/transactions/business")
    public String viewBusinessTransactionsPage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BusinessTransactions> businessTransactionsList = businessTransactionsDao.findBusinessTransactionsByBusinessId(user.getId());
        view.addAttribute("businessTransactions", businessTransactionsList);
        return "business/transactions";
    }

    @GetMapping("/sales")
    public String viewBusinessSalesPage(Model view) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Sale> salesList = saleDao.findSaleByBusinessId(user.getId());
        //List<Sale> businessSalesList = businessDao.findbusinessSalesbyBusinessId(id);

//        for(Sale sale : salesList){
//            System.out.println(sale.getProfit());
//            System.out.println(sale.getSaleDate());
//        };

        view.addAttribute("sales", salesList);
        //view.addAttribute("businessSales", businessSalesList);
        return "business/sales";
    }
}
