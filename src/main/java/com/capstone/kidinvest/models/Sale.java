package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.util.Date; //is this the right import?

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @Column(name = "sale_date")
    private Date saleDate;

    private double profit;

    @ManyToOne
    @JoinColumn (name = "business_id")
    private Business business;

    //blank constructor
    public Sale(){};

    //constructor
    public Sale(Date saleDate, double profit, Business business){
        this.saleDate = saleDate;
        this.profit = profit;
        this.business = business;
    }

    //getters and setters
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
