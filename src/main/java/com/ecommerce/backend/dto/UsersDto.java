package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UsersDto {
    private String user_id;
    private String name;
    private String email;
    private String city;
    private LocalDate signup_date;

//    public UsersDto(String user_id, String name, String email, String city, LocalDate signup_date) {
//        this.user_id = user_id;
//        this.name = name;
//        this.email = email;
//        this.city = city;
//        this.signup_date = signup_date;
//    }

}
