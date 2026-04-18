package com.ecommerce.backend.service.Impl;

import com.ecommerce.backend.dto.OrderItemsDTO;
import com.ecommerce.backend.mapper.OrderItemsMapper;
import com.ecommerce.backend.repository.OrderItemsRepository;
import com.ecommerce.backend.service.OrderItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {
    private final OrderItemsRepository orderItemsRepository;

    public OrderItemsServiceImpl(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public List<OrderItemsDTO> getFindAllOrderItems() {
        return orderItemsRepository.findAll()
                .stream()
                .map(OrderItemsMapper::toDto)
                .toList();
    }
}
