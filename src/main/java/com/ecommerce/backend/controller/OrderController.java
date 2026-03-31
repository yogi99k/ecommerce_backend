package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrdersById(@PathVariable String id){
        return orderService.getOrdersById(id);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable String userId) {
        return orderService.getOrdersByUserId(userId);
    }
}
