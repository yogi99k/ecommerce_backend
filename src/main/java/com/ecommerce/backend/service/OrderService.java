package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.dto.ProductsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderDTO getOrdersById(String id);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByUserId(String userId);

    List<OrderDTO> filterByStatus(String status);
}
