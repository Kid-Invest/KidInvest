package com.capstone.kidinvest.models;

import javax.persistence.*;

@Entity
@Table(name = "addons")
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "popularity_bonus", nullable = false, columnDefinition = "Unsigned")
    private int popularityBonus;

    @ManyToOne
    @JoinColumn (name = "business_id")
    private Business business;

    //blank constructor
    public Addon(){};

    //constructor
    public Addon(long id, int popularityBonus){
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

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
}
