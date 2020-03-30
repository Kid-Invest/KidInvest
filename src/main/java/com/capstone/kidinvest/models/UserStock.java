package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_has_stocks")
public class UserStock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Stock stock;

    @Column
    private long shares;

    //Default Constructor
    public UserStock() {
    }

    //Constructor
    public UserStock(long shares) {
        this.shares = shares;
    }

    //Getters
    public long getShares() {
        return this.shares;
    }

    //Setters
    public void setShares(long shares) {
        this.shares = shares;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
