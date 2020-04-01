package com.capstone.kidinvest.services;

import com.capstone.kidinvest.models.Stock;
import com.capstone.kidinvest.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RestService {

    //RestTemplate Builder & DAO/Injection
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    //api token and Stock Tickers
    private final String apiToken = "api_token=d6PTrQRT1GGzuevKIczQxeFHLKLh6VSSztliEAAAUgC70AjjvhREy2xwqqKe";
    private final String stocks = "TUP,GME,BKS,WOW,VVNT,BGS,YETI,TWTR,WFC,RCL,DELL,GMED,WRB,PSX,GPC,FRT,GWRE,OGS,EXR,TM";


    //Request returns in JSON format
    public String getStocksPlainJSON(){
        String url = "https://api.worldtradingdata.com/api/v1/stock?symbol=" + stocks + "&" + apiToken + "&sort_by=name";
        return this.restTemplate.getForObject(url, String.class);
    }

//    public static void main(String[] args) {
//        RestService restService = new RestService(new RestTemplateBuilder());
//        RestService.parseJSONString(restService.getStocksPlainJSON());
//    }

    public List<Stock> parseJSONString(String jsonString) {
        jsonString = jsonString.replaceAll("\"", "");
        jsonString = jsonString.replaceAll(",", "");
        List<Stock> stockList = new ArrayList<>();
        String symbol, name, marketPrice, openPrice, highPrice, lowPrice, yearHighPrice, yearLowPrice;
        int beginningIndex = 0;
        int endingIndex = 0;
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
//        jsonString = jsonString.replaceAll("symbol:", "[symbol]");
        System.out.println(jsonString);
        while (jsonString.contains("{")) {

            symbol = jsonString.substring(jsonString.indexOf("symbol:") + 7, jsonString.indexOf("name:"));
            name = jsonString.substring(jsonString.indexOf("name:") + 5, jsonString.indexOf("currency:"));
            marketPrice = jsonString.substring(jsonString.indexOf("price:") + 6, jsonString.indexOf("price_open"));
            openPrice = jsonString.substring(jsonString.indexOf("price_open:") + 11 , jsonString.indexOf("day_high"));
            highPrice = jsonString.substring(jsonString.indexOf("day_high:") + 9, jsonString.indexOf("day_low"));
            lowPrice = jsonString.substring(jsonString.indexOf("day_low:") + 8, jsonString.indexOf("52_week_high"));
            yearHighPrice = jsonString.substring(jsonString.indexOf("52_week_high:") + 13, jsonString.indexOf("52_week_low"));
            yearLowPrice = jsonString.substring(jsonString.indexOf("52_week_low:") + 12, jsonString.indexOf("day_change"));
//            System.out.println("SYMBOL: " + symbol);
//            System.out.println("NAME: " + name);
//            System.out.println("MARKET PRICE: " + marketPrice);
//            System.out.println("OPEN PRICE: " + openPrice);
//            System.out.println("LOW PRICE: " + lowPrice);
//            System.out.println("HIGH PRICE: " + highPrice);
//            System.out.println("52-WEEK LOW PRICE: " + yearLowPrice);
//            System.out.println("52-WEEK HIGH PRICE: " + yearHighPrice);
//            Stock testStock = new Stock(1, name, Double.parseDouble(marketPrice), Double.parseDouble(openPrice), Double.parseDouble(lowPrice), Double.parseDouble(highPrice), time);
//            Stock stock = stockDao.

            stockList.add(new Stock(
                    Double.parseDouble(marketPrice),
                    Double.parseDouble(openPrice),
                    Double.parseDouble(lowPrice),
                    Double.parseDouble(highPrice),
                    Double.parseDouble(yearLowPrice),
                    Double.parseDouble(yearHighPrice)
            ));

//            Stock stock =  stockDao.findStockByTicker(symbol);
//            stock.setMarketPrice(Double.parseDouble(marketPrice));
//            stock.setOpenPrice(Double.parseDouble(openPrice));
//            stock.setLowPrice(Double.parseDouble(lowPrice));
//            stock.setHighPrice(Double.parseDouble(highPrice));
//            stock.setYearLowPrice(Double.parseDouble(yearLowPrice));
//            stock.setYearHighPrice(Double.parseDouble(yearHighPrice));

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
        return stockList;
    }

}


