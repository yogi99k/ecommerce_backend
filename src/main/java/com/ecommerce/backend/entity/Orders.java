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
@NamedQuery(
        name="Orders.CountOrdersPer_User",
        query="select o.users.userId, count(o.orderId) as num_of_orders from Orders o group by o.users.userId order by num_of_orders desc"
)
@NamedNativeQuery(
        name="Orders.getMonthlyRevenue",
        query="SELECT\n" +
                "    YEAR(order_date) AS year,\n" +
                "    MONTH(order_date) AS month,\n" +
                "    SUM(total_amount) AS monthly_revenue\n" +
                "FROM orders\n" +
                "GROUP BY YEAR(order_date), MONTH(order_date)\n" +
                "ORDER BY year, month;"

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
