package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lemonades")
public class Lemonade {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lemonade")
    List<LemonadeIngredient> lemonadeIngredients;

    public Lemonade() {
    }

    public Lemonade(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<LemonadeIngredient> getLemonadeIngredients() {
        return this.lemonadeIngredients;
    }

    public void setLemonadeIngredients(List<LemonadeIngredient> lemonadeIngredients) {
        this.lemonadeIngredients = lemonadeIngredients;
    }
}
