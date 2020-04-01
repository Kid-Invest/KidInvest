package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String ticker;

    @Column(name = "market_price", nullable = true)
    private double marketPrice;

    @Column(name = "open_price", nullable = true)
    private double openPrice;

    @Column(name = "low_price", nullable = true)
    private double lowPrice;

    @Column(name = "high_price", nullable = true)
    private double highPrice;

    @Column(name = "year_low_price", nullable = true)
    private double yearLowPrice;

    @Column(name = "year_high_price", nullable = true)
    private double yearHighPrice;

    @Column(nullable = true)
    private Timestamp time;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<StockTransaction> transactionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<UserStock> userStockList;

    // Defualt Constructor
    public Stock() {
    }

    //Constructor
    public Stock(long id, String name, String ticker, double marketPrice, double openPrice, double lowPrice, double highPrice, double yearLowPrice, double yearHighPrice,
                 Timestamp time) {
        this.id = id;
        this.name = name;
        this.ticker = ticker;
        this.marketPrice = marketPrice;
        this.openPrice = openPrice;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.yearLowPrice = yearLowPrice;
        this.yearHighPrice = yearHighPrice;
        this.time = time;
    }

    public Stock(double marketPrice, double openPrice, double lowPrice, double highPrice, double yearLowPrice, double yearHighPrice) {
        this.marketPrice = marketPrice;
        this.openPrice = openPrice;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.yearLowPrice = yearLowPrice;
        this.yearHighPrice = yearHighPrice;
    }

    // Getters
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTicker(){
        return this.ticker;
    }

    public double getMarketPrice() {
        return this.marketPrice;
    }

    public double getOpenPrice() {
        return this.openPrice;
    }

    public double getLowPrice() {
        return this.lowPrice;
    }

    public double getHighPrice() {
        return this.highPrice;
    }

    public double getYearLowPrice() {
        return this.yearLowPrice;
    }

    public double getYearHighPrice() {
        return this.yearHighPrice;
    }

    public Timestamp getTime() {
        return this.time;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public void setYearLowPrice(double yearLowPrice) {
        this.yearLowPrice = yearLowPrice;
    }

    public void setYearHighPrice(double yearHighPrice) {
        this.yearHighPrice = yearHighPrice;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
