package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderItemsDTO {

    private String orderItemId;
    private String orderId;
    private String productId;
    private String userId;
    private int quantity;
    private Double itemPrice;
    private Double itemTotal;

}
