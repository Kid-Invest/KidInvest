package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "stock_transactions")
public class StockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shares_bought_sold")
    private int sharesBoughtSold;

    @Column
    private double price;

    @Column
    private Date time;

    //Default Constructor
    public StockTransaction() {}

    //Getters
    public long getId() { return this.id; }
    public int getSharesBoughtSold() { return this.sharesBoughtSold; }
    public double getPrice() { return this.price; }
    public Date getTime() { return this.time; }

    //Setters
    public void setId(long id) { this.id = id; }
    public void setSharesBoughtSold(int sharesBoughtSold) { this.sharesBoughtSold = sharesBoughtSold; }
    public void setPrice(double price) { this.price = price; }
    public void setTime(Date time) { this.time = time; }
}
