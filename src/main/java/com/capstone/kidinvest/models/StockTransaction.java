package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "stock_transactions")
public class StockTransaction implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @Id
    @ManyToOne
    @JoinColumn
    private Stock stock;

    @Column(name = "shares_bought_sold")
    private long sharesBoughtSold;

    @Column
    private double price;

    @Column
    private Date time;

    //Default Constructor
    public StockTransaction() {}

    //Getters
    public long getSharesBoughtSold() { return this.sharesBoughtSold; }
    public double getPrice() { return this.price; }
    public Date getTime() { return this.time; }

    //Setters
    public void setSharesBoughtSold(long sharesBoughtSold) { this.sharesBoughtSold = sharesBoughtSold; }
    public void setPrice(double price) { this.price = price; }
    public void setTime(Date time) { this.time = time; }
}
