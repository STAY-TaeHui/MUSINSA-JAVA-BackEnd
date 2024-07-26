package org.example.musinsabackend.service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.ProductInfoWithBrandApi;
import org.example.musinsabackend.domain.Category;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportApiService
{
    private final CategoryService categoryService;
    private final ProductService productService;
    public int lowestPriceProductByCategory()
    {
        //TODO
        //카테고리 별로 최저가격의 상품을 조회한 다음 해당 상품의 브랜드와 상품 가격, 마지막으로 총 가격을 조회하는 기능.

        int totalPrice = 0;
        List<Category> categories = categoryService.getCategories();
        List<ProductInfoWithBrandApi> lowestPriceProducts  = new ArrayList<>();

        for (Category category : categories)
        {
            ProductInfoWithBrandApi lowestPriceProductByCategoryId = productService.getLowestPriceProductByCategoryId(category);
            lowestPriceProducts.add(lowestPriceProductByCategoryId);

            totalPrice += lowestPriceProductByCategoryId.getPrice();
        }

        return totalPrice;


        // 해당 상품의 브랜드와 상품 가격, 총액을 조회

    }
}
