package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "stock_transactions")
public class StockTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Stock stock;

    @Column(name = "shares_bought_sold")
    private long sharesBoughtSold;

    @Column
    private double price;

    @Column
    private Timestamp time;

    //Default Constructor
    public StockTransaction() {
    }

    //Constructor
    public StockTransaction(long sharesBoughtSold, double price, Timestamp time) {
        this.sharesBoughtSold = sharesBoughtSold;
        this.price = price;
        this.time = time;
    }

    //Getters
    public long getSharesBoughtSold() {
        return this.sharesBoughtSold;
    }

    public double getPrice() {
        return this.price;
    }

    public Timestamp getTime() {
        return this.time;
    }

    //Setters
    public void setSharesBoughtSold(long sharesBoughtSold) {
        this.sharesBoughtSold = sharesBoughtSold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
