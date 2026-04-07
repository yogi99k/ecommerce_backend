package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Orders;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,String> {
    List<Orders> findByUsersUserId(String userId);

    @Query("SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus")
    List<Orders> filterByOrderStatus(@Param("orderStatus") String orderStatus);

    //List<Orders> findByOrderDateBetweenOrderByOrderDate(LocalDateTime start, LocalDateTime end);
    @Query("select o from Orders o where o.orderDate Between :startDate and :endDate order by o.orderDate ")
    List<Orders> filterByDateRange(@Param("startDate")LocalDateTime startDate,
                                   @Param("endDate") LocalDateTime endDate);

//    @Query("select o from Orders o where o.totalAmount > :amount")
//    List<Orders> filterByAmount(@Param("amount")float amount);

    List<Orders> findByTotalAmountGreaterThan(float amount, Sort sort);

}
