package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_items")
@Getter @Setter @ToString @NoArgsConstructor
public class OrderItems {
    @Id
    @Column(name="order_item_id")
    private String orderItemId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id",nullable = false)
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id",nullable = false)
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private Users user;

    @Column(name="quantity")
    private int quantity;

    @Column(name="item_price")
    private Double itemPrice;

    @Column(name="item_total")
    private Double itemTotal;

}
