package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.OrderItemsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemsService {

    List<OrderItemsDTO> getFindAllOrderItems();
}
