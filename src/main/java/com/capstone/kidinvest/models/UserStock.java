package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_has_stocks")
public class UserStock implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @Id
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
}
