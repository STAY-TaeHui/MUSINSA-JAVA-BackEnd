package org.example.musinsabackend.repository;

import java.util.List;
import java.util.Optional;

import org.example.musinsabackend.api.dto.LowestBrandInfoDto;
import org.example.musinsabackend.api.dto.LowestBrandProductInfoDto;
import org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto;
import org.example.musinsabackend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

public interface ProductJpaRepository extends JpaRepository<Product, Long>
{
    @Query("SELECT new org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto(b.name, p.price) " +
        "FROM Product p JOIN p.brand b WHERE p.category.id = :categoryId " +
        "ORDER BY p.price ASC LIMIT 1")
    ProductPriceAndBrandNameDto findTopByCategoryOrderByPriceWithBrand(@Param("categoryId") Long categoryId);


    @Query("SELECT new org.example.musinsabackend.api.dto.LowestBrandInfoDto(p.brand.id, p.brand.name, SUM(p.price)) " +
        "FROM Product p " +
        "GROUP BY p.brand.id " +
        "ORDER BY SUM(p.price) ASC LIMIT 1")
    Optional<LowestBrandInfoDto> findTopBrandIdByBrandIdOrderByPrice();


    @Query("SELECT new org.example.musinsabackend.api.dto.LowestBrandProductInfoDto(p.category.name, p.price) " +
        "FROM Product p " +
        "WHERE p.brand.id = :id ")
    Optional<List<LowestBrandProductInfoDto>> findByBrand_Id(@NonNull Long id);


    Optional<List<Product>> findByCategory_Name(String categoryName);


    @Query("SELECT new org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto(p.brand.name, p.price) " +
        "FROM Product p " +
        "WHERE p.price = " +
        "(SELECT MIN(p.price) FROM Product p WHERE p.category.name = :categoryName)")
    Optional<List<ProductPriceAndBrandNameDto>> findTopByCategoryNameOrderByPriceWithBrand(String categoryName);


    @Query("SELECT new org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto(p.brand.name, p.price) " +
        "FROM Product p " +
        "WHERE p.price = " +
        "(SELECT MAX(p.price) FROM Product p WHERE p.category.name = :categoryName)")
    Optional<List<ProductPriceAndBrandNameDto>> findTopByCategoryNameOrderByPriceWithBrandDesc(String categoryName);
}
