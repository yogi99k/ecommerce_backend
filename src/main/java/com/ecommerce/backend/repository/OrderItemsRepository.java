package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,String> {

    //List<OrderItems> findAllOrderItems();
}
