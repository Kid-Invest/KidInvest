package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private int popularity;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<BusinessTransactions> businessTransactions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "business_has_addons", joinColumns = {@JoinColumn(name = "business_id")}, inverseJoinColumns = {@JoinColumn(name = "addon_id")})
    private List<Addon> addons;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Inventory> inventory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Sale> businessSales;

    //blank constructor
    public Business() {
    }

    ;

    //constructor
    public Business(long id, String name, int popularity, User user) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.user = user;
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

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
