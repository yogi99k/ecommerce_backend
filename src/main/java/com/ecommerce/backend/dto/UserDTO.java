package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter @Setter
public class UserDTO {
    private Long userId;
    private String name;
    private String mobileNumber;
    private String role;
    private Long orderId;
    //private String orderName;
    private Instant createdAt;
}
