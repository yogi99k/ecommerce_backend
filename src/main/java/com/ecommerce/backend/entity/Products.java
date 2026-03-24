package com.ecommerce.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="products")
@Getter
@Setter
public class Products {

    @Id
    @Column(name="product_id",nullable = false)
    private String product_id;
    @Column(name="product_name",nullable = false)
    private String product_name;
    @Column(name="category")
    private String category;
    @Column(name="brand")
    private String brand;
    @Column(name="price")
    private double price;
    @Column(name="rating")
    private double rating;

}
