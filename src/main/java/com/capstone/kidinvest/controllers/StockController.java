package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.models.StockTransaction;
import com.capstone.kidinvest.models.UserStock;
import com.capstone.kidinvest.repositories.StockRepo;
import com.capstone.kidinvest.repositories.StockTransactionRepo;
import com.capstone.kidinvest.repositories.UserStockRepo;
import com.capstone.kidinvest.services.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
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

        List<Stock> retrieveStockList = restService.parseJSONString(restService.getStocksPlainJSON());


        List<Stock> stockList = stockDao.findAll();

//        for(int i = 0; i < stockList.size(); i++){
//            stockList.get(i).setMarketPrice(retrieveStockList.get(i).getMarketPrice());
//            stockList.get(i).setOpenPrice(retrieveStockList.get(i).getOpenPrice());
//            stockList.get(i).setLowPrice(retrieveStockList.get(i).getLowPrice());
//            stockList.get(i).setHighPrice(retrieveStockList.get(i).getHighPrice());
//            stockList.get(i).setYearLowPrice(retrieveStockList.get(i).getYearLowPrice());
//            stockList.get(i).setYearHighPrice(retrieveStockList.get(i).getYearHighPrice());
//        }
        for (Stock stock : stockList) {
//            stockDao.save(stock);
            System.out.println(stock.getName());
        }

       // view.addAttribute("stocks", stockList);
        return "/";
    }
}
