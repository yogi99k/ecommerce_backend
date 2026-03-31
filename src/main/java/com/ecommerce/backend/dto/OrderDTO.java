package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter @Setter
@ToString
public class OrderDTO {
        private String orderId;
        private String userId;
        private LocalDateTime orderDate;
        private String orderStatus;
        private float totalAmount;
}
