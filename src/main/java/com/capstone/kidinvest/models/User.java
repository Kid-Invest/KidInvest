package com.capstone.kidinvest.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
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

    private double balance;

    @Column(name = "character_id")
    private int characterId;

    @Column(name = "viewed_portfolio")
    private boolean viewedPortfolio;

    @Column(name = "viewed_stocks")
    private boolean viewedStocks;

    @Column(name = "viewed_stand")
    private boolean viewedStand;

    @Column(name = "viewed_business")
    private boolean viewedBusiness;

    @Column(name = "completed_stock_quiz")
    private boolean takenStockQuiz;

    @Column(name = "completed_business_quiz")
    private boolean takenBusinessQuiz;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<StockTransaction> transactionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserStock> userStockList;

    //blank constructor
    public User() {
    }

    //constructor
    public User(long id, String username, String password, String email, Double balance, int characterId, boolean viewedPortfolio, boolean viewedStocks, boolean viewedStand, boolean viewedBusiness, boolean takenStockQuiz, boolean takenBusinessQuiz) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.characterId = characterId;
        this.viewedPortfolio = viewedPortfolio;
        this.viewedStocks = viewedStocks;
        this.viewedStand = viewedStand;
        this.viewedBusiness = viewedBusiness;
        this.takenStockQuiz = takenStockQuiz;
        this.takenBusinessQuiz = takenBusinessQuiz;
    }

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.password = copy.password;
        this.email = copy.email;
        this.balance = copy.balance;
        this.characterId = copy.characterId;
        this.viewedPortfolio = copy.viewedPortfolio;
        this.viewedStocks = copy.viewedStocks;
        this.viewedStand = copy.viewedStand;
        this.viewedBusiness = copy.viewedBusiness;
        this.takenStockQuiz = copy.takenStockQuiz;
        this.takenBusinessQuiz = copy.takenBusinessQuiz;
    }

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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public boolean getTakenStockQuiz() {
        return takenStockQuiz;
    }

    public void setTakenStockQuiz(boolean takenStockQuiz) {
        this.takenStockQuiz = takenStockQuiz;
    }

    public boolean getTakenBusinessQuiz() {
        return takenBusinessQuiz;
    }

    public void setTakenBusinessQuiz(boolean takenBusinessQuiz) {
        this.takenBusinessQuiz = takenBusinessQuiz;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<StockTransaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<StockTransaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<UserStock> getUserStockList() {
        return userStockList;
    }

    public void setUserStockList(List<UserStock> userStockList) {
        this.userStockList = userStockList;
    }

    public boolean isTakenStockQuiz() {
        return takenStockQuiz;
    }

    public boolean isTakenBusinessQuiz() {
        return takenBusinessQuiz;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public boolean isViewedPortfolio() {
        return viewedPortfolio;
    }

    public void setViewedPortfolio(boolean viewedPortfolio) {
        this.viewedPortfolio = viewedPortfolio;
    }

    public boolean isViewedStocks() {
        return this.viewedStocks;
    }

    public void setViewedStocks(boolean viewedStocks) {
        this.viewedStocks = viewedStocks;
    }

    public boolean isViewedStand() {
        return viewedStand;
    }

    public void setViewedStand(boolean viewedStand) {
        this.viewedStand = viewedStand;
    }

    public boolean isViewedBusiness() {
        return viewedBusiness;
    }

    public void setViewedBusiness(boolean viewedBusiness) {
        this.viewedBusiness = viewedBusiness;
    }
}
