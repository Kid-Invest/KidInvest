package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sale_date")
    private Date saleDate;

    private double profit;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    //blank constructor
    public Sale() {
    }

    ;

    //constructor
    public Sale(long id, Date saleDate, double profit, Business business) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
