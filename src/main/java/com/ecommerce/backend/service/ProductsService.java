package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductsDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {

    List<ProductsDTO> getAllProducts(int size,int page);

    ProductsDTO getProductsById(String id);

    ProductsDTO createProducts(ProductsDTO productsDTO);

    void deleteProduct(String id);

    List<ProductsDTO> getSortByRatingAndPrice(String ratingSort, String priceSort);

    Page<ProductsDTO> getPaginateOrdersWithStatusCancelled(int page, int size, float rating);
}
