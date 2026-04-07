package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,String> {
    List<Orders> findByUsersUserId(String userId);

    @Query("SELECT o FROM Orders o WHERE o.orderStatus = :orderStatus")
    List<Orders> filterByOrderStatus(@Param("orderStatus") String orderStatus);
}
