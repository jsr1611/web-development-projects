package com.example.personalPortfolio.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_warehouse")
public @Data
class UserWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", unique = true)
    private Long warehouseId;

    @Column(name = "user_id")
    private Long userId;

}
