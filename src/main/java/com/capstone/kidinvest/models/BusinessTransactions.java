package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "business_transactions")
public class BusinessTransactions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Business business;

    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    @Column(name = "purchase_count")
    private long purchaseCount;

    private Timestamp time;

    public BusinessTransactions() {
    }

    public BusinessTransactions(long id, Business business, Ingredient ingredient, long purchaseCount, Timestamp time) {
        this.id = id;
        this.business = business;
        this.ingredient = ingredient;
        this.purchaseCount = purchaseCount;
        this.time = time;
    }

    public BusinessTransactions(Business business, Ingredient ingredient, long purchaseCount, Timestamp time) {
        this.business = business;
        this.ingredient = ingredient;
        this.purchaseCount = purchaseCount;
        this.time = time;
    }

    public Business getBusiness() {
        return this.business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public long getPurchaseCount() {
        return this.purchaseCount;
    }

    public void setPurchaseCount(long purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Timestamp getTime() {
        return this.time;
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
}
