package org.example.musinsabackend.repository;

import java.util.Optional;

import org.example.musinsabackend.api.dto.ProductInfoWithBrandApi;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductJpaRepository extends JpaRepository<Product, Long>
{

    Optional<Product> findTopByCategoryOrderByPrice(Category category);

//    @Query("SELECT new org.example.musinsabackend.api.dto.ProductInfoWithBrandApi(p.price, b.name, p.price) FROM Product p JOIN p.brand b WHERE p.id = :productId")
    Optional<ProductInfoWithBrandApi> findProductInfoWithBrandById(Long productId);
}
