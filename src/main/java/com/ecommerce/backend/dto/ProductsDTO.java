package com.ecommerce.backend.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
public class ProductsDTO {
    private String product_id;
    private String product_name;
    private String category;
    private String brand;
    private double price;
    private double rating;
}
