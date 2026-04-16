package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.OrderItemsDTO;
import com.ecommerce.backend.entity.OrderItems;
import com.ecommerce.backend.entity.Orders;
import com.ecommerce.backend.entity.Products;
import com.ecommerce.backend.entity.Users;

public class OrderItemsMapper {
    public static OrderItemsDTO toDto(OrderItems orderItems){
        OrderItemsDTO orderItemsDTO = new OrderItemsDTO();
        orderItemsDTO.setOrderItemId(orderItems.getOrderItemId());
        orderItemsDTO.setOrderId(orderItems.getOrder().getOrderId());
        orderItemsDTO.setProductId(orderItems.getProducts().getProduct_id());
        orderItemsDTO.setUserId(orderItems.getUser().getUserId());
        orderItemsDTO.setQuantity(orderItems.getQuantity());
        orderItemsDTO.setItemPrice(orderItems.getItemPrice());
        orderItemsDTO.setItemTotal(orderItems.getItemTotal());
        return orderItemsDTO;
    }

    public static OrderItems toEntity(OrderItemsDTO orderItemsDTO){
        OrderItems orderItems = new OrderItems();

        orderItems.setOrderItemId(orderItemsDTO.getOrderItemId());

        // Set Order
        Orders order = new Orders();
        order.setOrderId(orderItemsDTO.getOrderId());
        orderItems.setOrder(order);

        // Set Product
        Products product = new Products();
        product.setProduct_id(orderItemsDTO.getProductId());
        orderItems.setProducts(product);

        // Set User
        Users user = new Users();
        user.setUserId(orderItemsDTO.getUserId());
        orderItems.setUser(user);

        orderItems.setQuantity(orderItemsDTO.getQuantity());
        orderItems.setItemPrice(orderItemsDTO.getItemPrice());
        orderItems.setItemTotal(orderItemsDTO.getItemTotal());

        return orderItems;
    }
}
