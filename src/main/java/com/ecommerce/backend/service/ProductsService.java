package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {

    List<ProductsDTO> getAllProducts();

    ProductsDTO getProductsById(String id);

    ProductsDTO createProducts(ProductsDTO productsDTO);

    void deleteProduct(String id);

    List<ProductsDTO> getSortByRatingAndPrice(String ratingSort, String priceSort);
}
