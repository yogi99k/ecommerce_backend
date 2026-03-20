package com.ecommerce.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="users")
@Getter
@Setter
public class Users {

    @Id
    @Column(name="user_id")
    private String user_id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String gender;
    @Column
    private String city;
    @Column
    private LocalDate signup_date;

}
