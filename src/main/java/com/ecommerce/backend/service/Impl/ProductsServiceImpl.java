package com.ecommerce.backend.service.Impl;

import com.ecommerce.backend.dto.ProductsDTO;
import com.ecommerce.backend.entity.Products;
import com.ecommerce.backend.mapper.ProductsMapper;
import com.ecommerce.backend.repository.ProductsRepository;
import com.ecommerce.backend.service.ProductsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
    public List<ProductsDTO> getAllProducts(int page,int size){
        Pageable pageable = PageRequest.of(page,size,Sort.by("price").descending());
        List<ProductsDTO> collect = productsRepository.findAll(pageable)
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

    @Override
    public List<ProductsDTO> getSortByRatingAndPrice(String ratingSort, String priceSort) {
        Sort sort = Sort.by(
                Sort.Order.by("rating").with(Sort.Direction.fromString(ratingSort)),
                Sort.Order.by("price").with(Sort.Direction.fromString(priceSort))
        );
        return productsRepository.findAll(sort)
                .stream()
                .map(ProductsMapper::toDto)
                .toList();
    }

    @Override
    public Page<ProductsDTO> getPaginateOrdersWithStatusCancelled(int page, int size, float rating) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("price").descending());
        return productsRepository.getPaginateOrdersWithStatusCancelled(rating,pageable)
                //.stream()
                .map(ProductsMapper::toDto);
                //.toList();
    }

    @Override
    public List<ProductsDTO> getDynamicAPI2(String category, Integer minPrice, Integer maxPrice, int page, int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("price").descending());

        Specification<Products> spec = (root, query, cb) -> cb.conjunction();
        if(category!=null){
            spec = spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("category"),category)));
        }
        if(minPrice!=null){
            spec =spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("price"),minPrice)));
        }
        if(maxPrice!=null){
            spec = spec.and(((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("price"),maxPrice)));
        }
        Page<Products> products = productsRepository.findAll(spec, pageable);
        return products.map(ProductsMapper::toDto).toList();

    }

    @Override
    public List<ProductsDTO> getProductsAboveCertainPriceAndRatingInDesc(double price,double rating, String sortDirection) {
        Sort sorts=sortDirection.equalsIgnoreCase("asc")
                ? Sort.by("price").ascending()
                : Sort.by("price").descending();
        return productsRepository.getProductsAboveCertainPriceAndRatingInDesc(price,rating,sorts)
                .stream()
                .map(ProductsMapper::toDto)
                .toList();
    }

}
