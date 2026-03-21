package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private final ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService=productsService;
    }

    @GetMapping
    public List<ProductsDTO> getAllProducts(){
        return productsService.getAllProducts();
    }
}
