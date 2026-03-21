package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.entity.Products;
import com.ecommerce.backend.mapper.ProductsMapper;
import com.ecommerce.backend.mapper.UsersMapper;
import com.ecommerce.backend.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    ProductsServiceImpl(ProductsRepository productsRepository){
        this.productsRepository=productsRepository;
    }

    @Override
    public List<ProductsDTO> getAllProducts(){
        List<ProductsDTO> collect = productsRepository.findAll()
                .stream()
                .map(ProductsMapper::toDto)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public ProductsDTO getProductsById(String id){
        Products products = productsRepository.findById(id).orElse(null);
        return ProductsMapper.toDto(products);
    }

    @Override
    public ProductsDTO createProducts(ProductsDTO productsDTO){
        Products product = ProductsMapper.toEntity(productsDTO);
        Products savedProduct = productsRepository.save(product);
        return ProductsMapper.toDto(savedProduct);
    }

    @Override
    public void deleteProduct(String id){
        productsRepository.deleteById(id);
    }
}
