package com.ecommerce.backend.service.Impl;

import com.ecommerce.backend.dto.OrderDTO;
import com.ecommerce.backend.dto.UsersDto;
import com.ecommerce.backend.entity.Orders;
import com.ecommerce.backend.mapper.OrderMapper;
import com.ecommerce.backend.mapper.UsersMapper;
import com.ecommerce.backend.repository.OrderRepository;
import com.ecommerce.backend.service.OrderService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO getOrdersById(String id){
        Orders orders = orderRepository.findById(id).orElse(null);
        return OrderMapper.toDTO(orders);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> collect = orderRepository.findAll().stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(String userId) {
        return orderRepository.findByUsers_UserId (userId)
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> filterByStatus(String status){
        //order status : 'shipped', 'returned', 'cancelled', 'processing', 'completed'
        return orderRepository.filterByOrderStatus(status)
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> filterByDateRange(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime  = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay();
        return orderRepository.filterByDateRange(startDateTime,endDateTime)
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> filterByAmount(float amount, String sortDir) {
        Sort sorts = sortDir.equalsIgnoreCase("desc")
                ? Sort.by("totalAmount").descending()
                : Sort.by("totalAmount").ascending();
        return orderRepository.findByTotalAmountGreaterThan(amount,sorts)
                .stream()
                .map(OrderMapper::toDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> getOrdersByUserIdAndStatus(String userId, String status) {
        if(status==null){
//            return orderRepository.filterByOrderStatus(userId)
//                    .stream()
//                    .map(OrderMapper::toDTO)
//                    .toList();
            return getOrdersByUserId(userId);
        }
        else
        {
            return orderRepository.findByUsers_UserIdAndOrderStatus(userId,status)
                    .stream()
                    .map(OrderMapper::toDTO)
                    .toList();
        }
    }

    @Override
    public List<OrderDTO> findByUsers_UserIdAndOrderDateBetween(String userId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay();
        return orderRepository.findByUsers_UserIdAndOrderDateBetween(userId,startDateTime,endDateTime)
                .stream()
                .map(OrderMapper::toDTO)
                .toList();

    }

    @Override
    public List<String> getUsersByXOrders(long value) {
        return orderRepository.findUsersWithMoreThanXOrders(value)
                .stream()
                //.map(UsersMapper::toDto)
                .toList();
    }
}
