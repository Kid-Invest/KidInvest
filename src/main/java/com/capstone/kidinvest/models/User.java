package com.capstone.kidinvest.models;

import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column()
    private Float balance;

    @Column(name = "viewed_portfolio")
    private boolean viewedPortfolio;

    @Column(name = "viewed_stocks")
    private boolean viewedStocks;

    @Column(name = "viewed_transactions")
    private boolean viewedTransactions;

    @Column(name = "viewed_stand")
    private boolean viewedStand;

    @Column(name = "viewed_store")
    private boolean viewedStore;

    //blank constructor
    public User(){};

    //constructor
    public User(long id, String username, String password, String email, Float balance, boolean viewedPortfolio, boolean viewedTransactions, boolean viewedStocks, boolean viewedStand, boolean viewedStore){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.viewedPortfolio = viewedPortfolio;
        this.viewedStocks = viewedStocks;
        this.viewedTransactions = viewedTransactions;
        this.viewedStand = viewedStand;
        this.viewedStore = viewedStore;
    };

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public boolean getViewedPages() {
        return viewedPortfolio;
    }

    public void setViewedPages(boolean viewedPortFolio) {
        this.viewedPortfolio = viewedPortFolio;
    }

    public boolean isViewedStocks() {
        return viewedStocks;
    }

    public void setViewedStocks(boolean viewedStocks) {
        this.viewedStocks = viewedStocks;
    }

    public boolean isViewedTransactions() {
        return viewedTransactions;
    }

    public void setViewedTransactions(boolean viewedTransactions) {
        this.viewedTransactions = viewedTransactions;
    }

    public boolean isViewedStand() {
        return viewedStand;
    }

    public void setViewedStand(boolean viewedStand) {
        this.viewedStand = viewedStand;
    }

    public boolean isViewedStore() {
        return viewedStore;
    }

    public void setViewedStore(boolean viewedStore) {
        this.viewedStore = viewedStore;
    }
}
