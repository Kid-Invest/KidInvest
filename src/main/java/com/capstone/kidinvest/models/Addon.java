package com.capstone.kidinvest.models;

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

    @ManyToMany(mappedBy = "addons")
    private List<Business> businessList;

    //blank constructor
    public Addon() {
    }

    ;

    //constructor
    public Addon(long id, int popularityBonus) {
        this.id = id;
        this.popularityBonus = popularityBonus;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPopularityBonus() {
        return popularityBonus;
    }

    public void setPopularityBonus(int popularityBonus) {
        this.popularityBonus = popularityBonus;
    }

    public List<Business> getBusinessList() {
        return businessList;
    }

    public void setBusinessList(List<Business> businessList) {
        this.businessList = businessList;
    }
}
