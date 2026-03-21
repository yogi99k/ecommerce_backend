package com.ecommerce.backend.mapper;

import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.entity.Products;

public class ProductsMapper  {
    public static ProductsDTO toDto(Products products){
        if(products==null) return null;
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setProduct_id(products.getProduct_id());
        productsDTO.setProduct_name(products.getProduct_name());
        productsDTO.setCategory(products.getCategory());
        productsDTO.setBrand(products.getBrand());
        productsDTO.setPrice(products.getPrice());
        productsDTO.setRating(products.getRating());
        return productsDTO;
    }

    public static Products toEntity(ProductsDTO productsDTO){
        if(productsDTO==null) return null;
        Products products = new Products();
        products.setProduct_id(productsDTO.getProduct_id());
        products.setProduct_name(productsDTO.getProduct_name());
        products.setCategory(productsDTO.getCategory());
        products.setBrand(productsDTO.getBrand());
        products.setPrice(productsDTO.getPrice());
        products.setRating(productsDTO.getRating());
        return products;
    }
}
