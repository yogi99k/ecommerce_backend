package com.ecommerce.backend.repository;

import com.ecommerce.backend.dto.TopUserTotalDTO;
import com.ecommerce.backend.entity.Orders;
import com.ecommerce.backend.entity.Users;
import org.apache.logging.log4j.simple.internal.SimpleProvider;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,String> {
    List<Orders> findByUsers_UserId (String userId);

    @Query("SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus")
    List<Orders> filterByOrderStatus(@Param("orderStatus") String orderStatus);

    //List<Orders> findByOrderDateBetweenOrderByOrderDate(LocalDateTime start, LocalDateTime end);
    @Query("select o from Orders o where o.orderDate Between :startDate and :endDate order by o.orderDate ")
    List<Orders> filterByDateRange(@Param("startDate")LocalDateTime startDate,
                                   @Param("endDate") LocalDateTime endDate);

//    @Query("select o from Orders o where o.totalAmount > :amount")
//    List<Orders> filterByAmount(@Param("amount")float amount);

    List<Orders> findByTotalAmountGreaterThan(float amount, Sort sort);

    List<Orders> findByUsers_UserIdAndOrderStatus(String userId, String status);

    List<Orders> findByUsers_UserIdAndOrderDateBetween(String userId, LocalDateTime startDate, LocalDateTime endDate);

//    @Query("""
//    SELECT u.user_id
//    FROM Users u
//    JOIN Orders o ON u.userId = o.users.userId
//    GROUP BY u
//    HAVING COUNT(o.orderId) > :count
//""")

    //only userid's
    @Query("""
    SELECT o.users.userId
    FROM Orders o
    GROUP BY o.users.userId
    HAVING COUNT(o.orderId) = :count
    """)
    List<String> findUsersWithMoreThanXOrders(@Param("count") long count);

    @Query("select sum(o.totalAmount) from Orders o where o.users.userId = :userId")
    Double getTotalOrderAmountbyUserId(@Param("userId") String userId);

    @Query("""
    SELECT
        o.users.userId,
        SUM(o.totalAmount)
    FROM Orders o
    GROUP BY o.users.userId
    ORDER BY SUM(o.totalAmount) DESC
""")
    List<Object[]> getTopUsersByTotalAmount(Pageable pageable);

}
