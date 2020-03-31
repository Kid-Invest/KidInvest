package com.capstone.kidinvest.controllers;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.services.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {
//    private RestService restService;

    @GetMapping("/")
    public String hello(){
//        System.out.println(restService.getStocksPlainJSON());
        return "index";
    }

    public static void main(String[] args) {
         RestService restService = new RestService(new RestTemplateBuilder());

//        System.out.println(restService.getStocksPlainJSON());
        HelloController.parseJSONString(restService.getStocksPlainJSON());
    }

    public static List<Stock> parseJSONString(String jsonString) {
        jsonString = jsonString.replaceAll("\"", "");
        jsonString = jsonString.replaceAll(",", "");
        List<Stock> stockList = new ArrayList<>();
        String symbol, name, marketPrice, openPrice, highPrice, lowPrice, yearHighPrice, yearLowPrice;
        int beginningIndex = 0;
        int endingIndex = 0;
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
//        System.out.println(date);
//        System.out.println(jsonString);

//        jsonString = jsonString.replaceAll("symbol:", "[symbol]");
        System.out.println(jsonString);
        while (jsonString.contains("{")) {
//            System.out.println("here");
//            System.out.println(jsonString);
            symbol = jsonString.substring(jsonString.indexOf("symbol:") + 7, jsonString.indexOf("name:"));
            name = jsonString.substring(jsonString.indexOf("name:") + 5, jsonString.indexOf("currency:"));
            marketPrice = jsonString.substring(jsonString.indexOf("price:") + 6, jsonString.indexOf("price_open"));
            openPrice = jsonString.substring(jsonString.indexOf("price_open:") + 11 , jsonString.indexOf("day_high"));
            highPrice = jsonString.substring(jsonString.indexOf("day_high:") + 9, jsonString.indexOf("day_low"));
            lowPrice = jsonString.substring(jsonString.indexOf("day_low:") + 8, jsonString.indexOf("52_week_high"));
            yearHighPrice = jsonString.substring(jsonString.indexOf("52_week_high:") + 13, jsonString.indexOf("52_week_low"));
            yearLowPrice = jsonString.substring(jsonString.indexOf("52_week_low:") + 12, jsonString.indexOf("day_change"));
            System.out.println("SYMBOL: " + symbol);
            System.out.println("NAME: " + name);
            System.out.println("MARKET PRICE: " + marketPrice);
            System.out.println("OPEN PRICE: " + openPrice);
            System.out.println("HIGH PRICE: " + highPrice);
            System.out.println("LOW PRICE: " + lowPrice);
            System.out.println("52-WEEK HIGH PRICE: " + yearHighPrice);
            System.out.println("52-WEEK LOW PRICE: " + yearLowPrice);
//            Stock testStock = new Stock(1, name, Double.parseDouble(marketPrice), Double.parseDouble(openPrice), Double.parseDouble(lowPrice), Double.parseDouble(highPrice), time);

//            System.out.println(testStock.getMarketPrice());
//            System.out.println("TIME: " + testStock.getTime());
            System.out.println();
//            System.out.println(jsonString.length());
            try {
                jsonString = jsonString.substring(jsonString.indexOf("}") + 1);
            } catch (StringIndexOutOfBoundsException siobe) {
                siobe.printStackTrace();
            }
        }
        return null;
    }

}


