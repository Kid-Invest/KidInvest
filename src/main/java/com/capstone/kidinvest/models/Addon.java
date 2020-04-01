package com.capstone.kidinvest.models;

import com.capstone.kidinvest.repositories.AddonRepo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "addons")
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "popularity_bonus", nullable = false)
    private int popularityBonus;

    private double price;

    @ManyToMany(mappedBy = "addons")
    private List<Business> businessList;

    //blank constructor
    public Addon() {
    }

    //constructor
    public Addon(long id, String name, int popularityBonus, double price) {
        this.id = id;
        this.name = name;
        this.popularityBonus = popularityBonus;
        this.price = price;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularityBonus() {
        return popularityBonus;
    }

    public void setPopularityBonus(int popularityBonus) {
        this.popularityBonus = popularityBonus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Business> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<Business> businessList) {
        this.businessList = businessList;
    }
}
