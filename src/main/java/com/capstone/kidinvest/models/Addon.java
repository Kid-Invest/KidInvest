package com.capstone.kidinvest.models;

import javax.persistence.*;

@Entity
@Table(name = "addons")
public class Addon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


}
