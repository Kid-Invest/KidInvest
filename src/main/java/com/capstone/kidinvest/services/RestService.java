package com.capstone.kidinvest.services;

import com.capstone.kidinvest.models.Stock;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    private final String apiToken = "api_token=d6PTrQRT1GGzuevKIczQxeFHLKLh6VSSztliEAAAUgC70AjjvhREy2xwqqKe";
    private final String stocks = "TUP,GME,BKS,WOW,VVNT,BGS,YETI,TWTR,WFC,RCL,DELL,GMED,WRB,PSX,GPC,FRT,GWRE,OGS,EXR,TM";
    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getStocksPlainJSON(){
        String url = "https://api.worldtradingdata.com/api/v1/stock?symbol=" + stocks + "&" + apiToken + "&sort_by=name";
        return this.restTemplate.getForObject(url, String.class);
    }

    public Stock[] getStocksAsObject(){
        String url = "https://api.worldtradingdata.com/api/v1/stock?symbol=SNAP,TWTR,VOD.L&" + apiToken;
        return this.restTemplate.getForObject(url, Stock[].class);
    }

    //USER STOCK TICKER SYMBOLS FOR URL PARAMS
    public Stock getStockWithUrlParameters(){
        String url = "https://api.worldtradingdata.com/api/v1/stock?symbol={stock1},{stock2},{stock3}&" + apiToken;
        return this.restTemplate.getForObject(url, Stock.class, "SNAP", "TWTR", "VOD.L");
    }

    public void updatePost(){
        String url = "https://api.worldtradingdata.com/api/v1/stock?symbol=SNAP,TWTR,VOD.L&" + apiToken;

    }
}


