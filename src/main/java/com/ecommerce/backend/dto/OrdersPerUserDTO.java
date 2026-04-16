package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class OrdersPerUserDTO {
    private String userId;
    private Long count;

    public OrdersPerUserDTO(String userId, Long count) {
        this.userId = userId;
        this.count = count;
    }
}
