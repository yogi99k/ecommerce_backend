package com.ecommerce.backend.repository;

import com.ecommerce.backend.entity.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String> {

    @Query(value = "select * from products where rating>3",nativeQuery = true)
    List<Products> getPaginateOrdersWithStatusCancelled(Pageable pageable);
}
