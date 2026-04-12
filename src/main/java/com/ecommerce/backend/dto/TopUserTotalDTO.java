package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class TopUserTotalDTO {
    private String userId;
    private Double totalAmount;

    public TopUserTotalDTO(String userId, Number totalAmount) {
        this.userId = userId;
        this.totalAmount = totalAmount.doubleValue();
    }
}
