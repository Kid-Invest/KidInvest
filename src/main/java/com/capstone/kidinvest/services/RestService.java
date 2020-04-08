package com.capstone.kidinvest.services;

import com.capstone.kidinvest.models.Stock;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;


@Service
public class RestService {

    //RestTemplate Builder & DAO/Injection
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //api token and Stock Tickers
//    private final String apiToken = "api_token=d6PTrQRT1GGzuevKIczQxeFHLKLh6VSSztliEAAAUgC70AjjvhREy2xwqqKe";
    private final String apiToken = "token=9c31ce94ea898d6f2aaa16dba11d47f3bc4d2499";
    private final String stocks = "TUP,GME,BKS,WOW,VVNT,BGS,YETI,TWTR,WFC,RCL,DELL,GMED,WRB,PSX,GPC,FRT,GWRE,OGS,EXR,TM";
//private final String stocks = "TUP";

    //Request returns in JSON format
    public String getStocksPlainJSON() {
//        String url = "https://api.worldtradingdata.com/api/v1/stock?symbol=" + stocks + "&" + apiToken + "&sort_by=name";
        String url = "https://api.tiingo.com/iex/?tickers=" + stocks + "&" + apiToken;
        return this.restTemplate.getForObject(url, String.class);
    }

    public static void main(String[] args) {
        RestService restService = new RestService(new RestTemplateBuilder());
        String objStr = restService.getStocksPlainJSON();
        List<Stock> stockList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(objStr);
            ArrayList<JSONObject> list = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                list.add((JSONObject) array.get(i));
            }

            for (JSONObject obj : list) {
//            System.out.println(obj.get("ticker"));
//            System.out.println(obj.get("tngoLast"));
//            System.out.println(obj.get("open"));
//            System.out.println(obj.get("low"));
//            System.out.println(obj.get("high"));

                stockList.add(new Stock(
                        Double.parseDouble(obj.get("tngoLast").toString()),
                        Double.parseDouble(obj.get("open").toString()),
                        Double.parseDouble(obj.get("low").toString()),
                        Double.parseDouble(obj.get("high").toString())
                ));
            }

//            for (Stock stock : stockList) {
//                System.out.println(stock.getMarketPrice());
//                System.out.println(stock.getHighPrice());
//                System.out.println(stock.getLowPrice());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Stock> retrieveStockData(String objStr) {
//        RestService restService = new RestService(new RestTemplateBuilder());
//        String objStr = restService.getStocksPlainJSON();
        List<Stock> stockList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray array = (JSONArray) parser.parse(objStr);
            ArrayList<JSONObject> list = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                list.add((JSONObject) array.get(i));
            }

            for (JSONObject obj : list) {
//            System.out.println(obj.get("ticker"));
//            System.out.println(obj.get("tngoLast"));
//            System.out.println(obj.get("open"));
//            System.out.println(obj.get("low"));
//            System.out.println(obj.get("high"));

                stockList.add(new Stock(
                        Double.parseDouble(obj.get("tngoLast").toString()),
                        Double.parseDouble(obj.get("open").toString()),
                        Double.parseDouble(obj.get("low").toString()),
                        Double.parseDouble(obj.get("high").toString())
                ));
            }

//            for (Stock stock : stockList) {
//                System.out.println(stock.getMarketPrice());
//                System.out.println(stock.getHighPrice());
//                System.out.println(stock.getLowPrice());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }

    public List<Stock> parseJSONString(String jsonString) {
//        jsonString = jsonString.replaceAll("\"", "");
//        jsonString = jsonString.replaceAll(",", "");
        List<Stock> stockList = new ArrayList<>();
        String symbol, name, marketPrice, openPrice, highPrice, lowPrice, yearHighPrice, yearLowPrice;
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());

        System.out.println(jsonString);
        while (jsonString.contains("{")) {

//            symbol = jsonString.substring(jsonString.indexOf("symbol:") + 7, jsonString.indexOf("name:"));
//            name = jsonString.substring(jsonString.indexOf("name:") + 5, jsonString.indexOf("currency:"));
//            marketPrice = jsonString.substring(jsonString.indexOf("price:") + 6, jsonString.indexOf("price_open"));
//            openPrice = jsonString.substring(jsonString.indexOf("price_open:") + 11 , jsonString.indexOf("day_high"));
//            highPrice = jsonString.substring(jsonString.indexOf("day_high:") + 9, jsonString.indexOf("day_low"));
//            lowPrice = jsonString.substring(jsonString.indexOf("day_low:") + 8, jsonString.indexOf("52_week_high"));
//            yearHighPrice = jsonString.substring(jsonString.indexOf("52_week_high:") + 13, jsonString.indexOf("52_week_low"));
//            yearLowPrice = jsonString.substring(jsonString.indexOf("52_week_low:") + 12, jsonString.indexOf("day_change"));

//            marketPrice = jsonString.substring(jsonString.indexOf("tngoLast:") + 9, jsonString.indexOf("askPrice"));
            marketPrice = jsonString.substring(jsonString.indexOf("tngoLast:") + 9, jsonString.indexOf("tngoLast:"));
            openPrice = jsonString.substring(jsonString.indexOf("open:") + 5, jsonString.indexOf("prevClose"));
//            System.out.println("open: " + openPrice);
//            System.out.println("low: " + jsonString.substring(jsonString.indexOf("low:") + 4, jsonString.indexOf(
//                    "last:")));
            lowPrice = jsonString.substring(jsonString.indexOf("low:") + 4, jsonString.indexOf("last:"));
            highPrice = jsonString.substring(jsonString.indexOf("high:") + 5, jsonString.indexOf("}"));
            System.out.println("market price: " + marketPrice);
            System.out.println("open price: " + openPrice);
            System.out.println("low price: " + lowPrice);
            System.out.println("high price: " + highPrice);

//            stockList.add(new Stock(
//                    Double.parseDouble(marketPrice),
//                    Double.parseDouble(openPrice),
//                    Double.parseDouble(lowPrice),
//                    Double.parseDouble(highPrice),
//                    Double.parseDouble(yearLowPrice),
//                    Double.parseDouble(yearHighPrice)
//            ));

            stockList.add(new Stock(
                    Double.parseDouble(marketPrice),
                    Double.parseDouble(openPrice),
                    Double.parseDouble(lowPrice),
                    Double.parseDouble(highPrice)
            ));

            try {
                jsonString = jsonString.substring(jsonString.indexOf("}") + 1);
            } catch (StringIndexOutOfBoundsException siobe) {
                siobe.printStackTrace();
            }
        }
        return stockList;
    }
}


