package com.ecommerce.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="orders")
public class Orders {

    @Id
    @Column(name="order_id")
    private String orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private Users users;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="total_amount")
    private float totalAmount;

}
