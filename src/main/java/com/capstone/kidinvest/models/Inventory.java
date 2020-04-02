package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Business business;

    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    private long total;

    public Inventory() {
    }

    public Inventory(long id, Business business, Ingredient ingredient, long total){
        this.id = id;
        this.business = business;
        this.ingredient = ingredient;
        this.total = total;
    }

    public Inventory(Business business, Ingredient ingredient, long total){
        this.business = business;
        this.ingredient = ingredient;
        this.total = total;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
