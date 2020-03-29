package com.capstone.kidinvest.models;

import javax.persistence.*;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, unique = true)
    String name;

    @Column (nullable = false)
    double cost;

}
