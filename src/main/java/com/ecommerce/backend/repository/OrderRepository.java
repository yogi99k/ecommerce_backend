package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,String> {

}
