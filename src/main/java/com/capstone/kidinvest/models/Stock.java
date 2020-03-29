package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "market_price", nullable = false)
    private double marketPrice;

    @Column(name = "open_price", nullable = false)
    private double openPrice;

    @Column(name = "low_price", nullable = false)
    private double lowPrice;

    @Column(name = "high_price", nullable = false)
    private double highPrice;

    @Column(nullable = false)
    private Timestamp time;

    // Defualt Constructor
    public Stock() {}

    // Getters
    public long getId() { return this.id; }
    public String getName() { return this.name; }
    public double getMarketPrice() { return this.marketPrice; }
    public double getOpenPrice() { return this.openPrice; }
    public double getLowPrice() { return this.lowPrice; }
    public double getHighPrice() { return this.highPrice; }
    public Timestamp getTime() { return this.time; }

    // Setters
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMarketPrice(double marketPrice) { this.marketPrice = marketPrice; }
    public void setOpenPrice(double openPrice) { this.openPrice = openPrice; }
    public void setLowPrice(double lowPrice) { this.lowPrice = lowPrice; }
    public void setHighPrice(double highPrice) { this.highPrice = highPrice; }
    public void setTime(Timestamp time) { this.time = time; }
}
