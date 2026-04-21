package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
public class Users {

    @Id
    @Column(name="user_id")
    private String userId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String gender;
    @Column
    private String city;
    @Column(name = "signup_date")
    private LocalDate signupDate;

    @OneToMany(mappedBy = "users", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

}
