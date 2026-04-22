package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private final ProductsService productsService;

    ProductsController(ProductsService productsService){
        this.productsService=productsService;
    }

    //Paginate products, sorted by price descending
    @GetMapping("/getAll")
    public List<ProductsDTO> getAllProducts(@RequestParam int page,
                                            @RequestParam int size){
        return productsService.getAllProducts(page,size);
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

    //Sort products by rating descending, then price ascending
    @GetMapping("/A2b/SortByRatig&Price")
    public List<ProductsDTO> getSortByRatingAndPrice(@RequestParam(required = false,defaultValue = "desc") String ratingSort,
                                                  @RequestParam(required = false,defaultValue = "desc") String priceSort){
        return productsService.getSortByRatingAndPrice(ratingSort, priceSort);
    }
    //Paginate orders with status = cancelled
    @GetMapping("/A2b/PaginateOrdersWithStatusCancelled")
    public Page<ProductsDTO> getPaginateOrdersWithStatusCancelled(@RequestParam int page,
                                                                  @RequestParam int size,
                                                                  @RequestParam float rating){
        return productsService.getPaginateOrdersWithStatusCancelled(page,size,rating);
    }
}
