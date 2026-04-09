package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.service.OrderService;
import org.springdoc.core.converters.models.Sort;
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

    @GetMapping("/filter/daterange")
    public List<OrderDTO> filterByDateRange(@RequestParam LocalDate startDate,
                                            @RequestParam LocalDate endDate){
        return orderService.filterByDateRange(startDate,endDate);
    }

    @GetMapping("/filter/amount")
    public List<OrderDTO> filterByAmount(@RequestParam float amount,
                                         @RequestParam(defaultValue = "asc") String sortDir){
        return orderService.filterByAmount(amount,sortDir);
    }

    //Get orders by userId + status
    /**
     * so the user will enter userid and status ?
     * Use @PathVariable → when it identifies a resource (mandatory, part of URL structure)
     * Use @RequestParam → when it filters/searches (optional or flexible inputs)
     */
    @GetMapping("/filter/byUserId&Status/{userId}")
    public List<OrderDTO> filterByUserIdAndStatus(@PathVariable String userId,
                                                  @RequestParam(required = false) String status){
        return orderService.getOrdersByUserIdAndStatus(userId,status);
    }

    //Get orders by userId + date range
    @GetMapping("/filter/OrdersByUserId&DateRange/{userId}")
    public List<OrderDTO> getOrdersByUserIdAndDateRange(@PathVariable String userId,
                                                        @RequestParam LocalDate startDate,
                                                        @RequestParam LocalDate endDate){
        return orderService.findByUsers_UserIdAndOrderDateBetween(userId,startDate,endDate);
    }
}
