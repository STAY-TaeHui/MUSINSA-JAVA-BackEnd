package org.example.musinsabackend.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.ProductInfoWithBrandApi;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.domain.Product;
import org.example.musinsabackend.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ProductService
{
    private final ProductJpaRepository productJpaRepository;

    public List<Product> getProducts()
    {
        return productJpaRepository.findAll();
    }

    /*
    * 카테고리 아이디에 해당하는 상품들 중에서 가격이 가장 낮은 상품을 조회하는 기능
    * @param categoryId 카테고리 아이디
    * @return 가격이 가장 낮은 상품
    */
    public ProductInfoWithBrandApi getLowestPriceProductByCategoryId(Category category)
    {
        return new ProductInfoWithBrandApi(
            productJpaRepository.findTopByCategoryOrderByPrice(category).orElseThrow()
        );
    }

    public ProductInfoWithBrandApi getProductInfoWithBrand(Long productId)
    {
        return productJpaRepository.findProductInfoWithBrandById(productId).orElseThrow();
    }

}
