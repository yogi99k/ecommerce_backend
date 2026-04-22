package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String> {

    @Query( value = "SELECT * FROM products WHERE rating >= :rating",
            countQuery = "SELECT COUNT(*) FROM products WHERE rating = :rating",
            nativeQuery = true)
    Page<Products> getPaginateOrdersWithStatusCancelled(@Param("rating") float rating, Pageable pageable);
}
