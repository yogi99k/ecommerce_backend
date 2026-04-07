package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    //Get Orders by Status
    @GetMapping("/filter/status")
    public List<OrderDTO> filterByStatus(@RequestParam String status){
        return orderService.filterByStatus(status);
    }

    @GetMapping("filter/daterange")
    public List<OrderDTO> filterByDateRange(@RequestParam LocalDate startDate,
                                            @RequestParam LocalDate endDate){
        return orderService.filterByDateRange(startDate,endDate);
    }
}
