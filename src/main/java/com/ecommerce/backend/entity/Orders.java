package com.ecommerce.backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@NamedQuery(
        name = "find_orders_by_status",
        query = "SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus"
)
@Getter @Setter
public class Orders {

    @Id
    @Column(name="order_id")
    private String orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private Users users;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="total_amount")
    private float totalAmount;

}
