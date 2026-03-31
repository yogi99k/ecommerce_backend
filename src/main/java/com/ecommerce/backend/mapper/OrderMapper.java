package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.entity.Orders;
import com.ecommerce.backend.entity.Users;

public class OrderMapper {

    public static OrderDTO toDTO(Orders order) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderId(order.getOrderId());
        dto.setUserId(order.getUsers().getUserId());
        dto.setOrderDate(order.getOrderDate());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setTotalAmount(order.getTotalAmount());
        return dto;
    }

    public static Orders toEntity(OrderDTO dto, Users user) {
        Orders order = new Orders();
        order.setOrderId(dto.getOrderId());
        order.setUsers(user);
        order.setOrderDate(dto.getOrderDate());
        order.setOrderStatus(dto.getOrderStatus());
        order.setTotalAmount(dto.getTotalAmount());
        return order;
    }
}
