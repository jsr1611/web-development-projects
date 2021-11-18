package com.example.personalPortfolio.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WAREHOUSE")
public @Data
class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;
}
