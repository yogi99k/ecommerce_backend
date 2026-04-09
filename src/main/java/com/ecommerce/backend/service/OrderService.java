package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.dto.UsersDto;
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

    List<OrderDTO> getOrdersByUserIdAndStatus(String userId, String status);

    List<OrderDTO> findByUsers_UserIdAndOrderDateBetween(String userId, LocalDate startDate, LocalDate endDate);

    List<UsersDto> getUsersByXOrders(long value);
}
