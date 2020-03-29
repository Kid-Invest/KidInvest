package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lemonades_has_ingredients")
public class LemonadeIngredient implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Lemonade lemonade;

    @Id
    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    @Column(nullable = true)
    private long count;

    public Lemonade getLemonade() {
        return this.lemonade;
    }

    public void setLemonade(Lemonade lemonade) {
        this.lemonade = lemonade;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
