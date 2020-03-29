package com.capstone.kidinvest.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "business_has_ingredient")
public class Inventory {

    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Ingredient ingredient;

    @Column(name="purchase_count")
    private long purchaseCount;

    private Timestamp time;

}
