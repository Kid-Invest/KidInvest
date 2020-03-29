package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="inventory")
public class Inventory implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Business businessInventory;

    @Id
    @ManyToOne
    @JoinColumn
    private Ingredient ingredientInventory;

    private long total;

    public Inventory() {
    }

    public Business getBusiness() {
        return this.businessInventory;
    }

    public void setBusiness(Business businessInventory) {
        this.businessInventory = businessInventory;
    }

    public Ingredient getIngredient() {
        return this.ingredientInventory;
    }

    public void setIngredient(Ingredient ingredientInventory) {
        this.ingredientInventory = ingredientInventory;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
