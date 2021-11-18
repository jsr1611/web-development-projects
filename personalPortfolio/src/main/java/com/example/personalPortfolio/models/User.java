package com.example.personalPortfolio.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "User")
public @Data
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "code")
    private String code;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;
}
