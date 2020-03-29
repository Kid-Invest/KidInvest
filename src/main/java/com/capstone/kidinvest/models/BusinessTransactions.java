package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "business_transactions")
public class BusinessTransactions implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Business business;

    @Id
    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    @Column(name = "purchase_count")
    private long purchaseCount;

    private Timestamp time;

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
}
