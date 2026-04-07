package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface OrderService {
    OrderDTO getOrdersById(String id);

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrdersByUserId(String userId);

    List<OrderDTO> filterByStatus(String status);

    List<OrderDTO> filterByDateRange(LocalDate startDate, LocalDate endDate);

    List<OrderDTO> filterByAmount(float amount, String sortDir);
}
