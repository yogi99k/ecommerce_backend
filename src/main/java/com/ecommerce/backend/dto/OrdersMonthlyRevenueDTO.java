package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter @Setter @ToString
public class OrdersMonthlyRevenueDTO {
    private int year;
    private int month;
    private BigDecimal monthly_revenue;

    public OrdersMonthlyRevenueDTO(int year, int month, BigDecimal monthly_revenue) {
        this.year = year;
        this.month = month;
        this.monthly_revenue = monthly_revenue;
    }
}
