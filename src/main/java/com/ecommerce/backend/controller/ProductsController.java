package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private final ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService=productsService;
    }

    @GetMapping(path="/public")
    public List<ProductsDTO> getAllProducts(){
        return productsService.getAllProducts();
    }

    @PostMapping
    public ProductsDTO createProduct(@RequestBody ProductsDTO productsDTO){
        return productsService.createProducts(productsDTO);
    }

    @GetMapping("/{id}")
    public ProductsDTO getProductsById(@PathVariable String id){
        return productsService.getProductsById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productsService.deleteProduct(id);
    }
}
