package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.OrderItemsDTO;
import com.ecommerce.backend.service.OrderItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemsController {
    private final OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @GetMapping("/findAll")
    public List<OrderItemsDTO> getFindAllOrderItems(){
        return orderItemsService.getFindAllOrderItems();
    }
}
