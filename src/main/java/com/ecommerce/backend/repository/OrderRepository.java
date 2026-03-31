package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,String> {
    List<Orders> findByUsersUserId(String userId);
}
