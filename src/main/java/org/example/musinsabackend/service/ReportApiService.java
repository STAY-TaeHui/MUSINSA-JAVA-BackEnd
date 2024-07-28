package org.example.musinsabackend.service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.LowestBrandInfoDto;
import org.example.musinsabackend.api.dto.LowestBrandProductInfoDto;
import org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto;
import org.example.musinsabackend.api.dto.ProductInfoWithBrandApiResponse;
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
        List<ProductPriceAndBrandNameDto> lowestPriceProducts  = new ArrayList<>();

        for (Category category : categories)
        {
            ProductPriceAndBrandNameDto lowestPriceProductByCategoryId = productService.getLowestPriceProductByCategoryId(category.getId());
            lowestPriceProducts.add(lowestPriceProductByCategoryId);

            totalPrice += lowestPriceProductByCategoryId.getPrice();
        }

        return totalPrice;
        // 해당 상품의 브랜드와 상품 가격, 총액을 조회
    }

    public LowestBrandInfoDto getLowestPriceBrand()
    {
        LowestBrandInfoDto lowestBrandInfoDto = productService.getLowestPriceBrandByBrandId();

        List<LowestBrandProductInfoDto> lowestBrandProductInfoDtos = productService.getProductInfoByBrandId(lowestBrandInfoDto.getBrandId());

        lowestBrandInfoDto.addAllLowestBrandProductInfoDtos(lowestBrandProductInfoDtos);

        return lowestBrandInfoDto;
    }

    //카테고리 이름으로 최저 가격의 상품과 최고 가격의 상품을 조회하는 기능
    public void LowestAndHighestPriceProductByCategoryName(String categoryName)
    {
        ProductInfoWithBrandApiResponse productPriceAndBrandNameDto = productService.getLowestPriceProductByCategoryName(categoryName);


    }


}
