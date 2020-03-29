package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Business business;

    @Id
    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    private long total;

    public Inventory() {
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

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
