package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (nullable = false)
    private double cost;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    List<LemonadeIngredient> lemonadeIngredients;

    public Ingredient() {
    }

    public Ingredient(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<LemonadeIngredient> getIngredient() {
        return this.lemonadeIngredients;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    List<BusinessTransactions> businessTransactions;

    public void setIngredient(List<LemonadeIngredient> lemonadeIngredients) {
        this.lemonadeIngredients = lemonadeIngredients;
    }
}
