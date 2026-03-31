package com.ecommerce.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UsersDto {
    @NotNull(message = "UserId cannot be empty")
    private String user_id;
    @NotNull(message = "Name cannot be empty")
    @Size(min=2,max = 100,message = "Name must be in 5 to 100 characters")
    private String name;
    @NotNull(message = "Email cannot be empty")
    @Email(message = "Invalid Email")
    private String email;
    @NotNull(message = "City cannot be empty")
    private String city;
    @NotNull(message = "Signup cannot be empty")
    private LocalDate signup_date;

}
