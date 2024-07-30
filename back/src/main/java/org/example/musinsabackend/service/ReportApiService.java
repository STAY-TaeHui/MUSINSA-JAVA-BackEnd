package org.example.musinsabackend.service;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.LowestBrandInfoDto;
import org.example.musinsabackend.api.dto.LowestBrandProductInfoDto;
import org.example.musinsabackend.api.dto.ProductInfoDto;
import org.example.musinsabackend.api.response.CategoryBrandPriceResponse;
import org.example.musinsabackend.api.response.ProductInfoWithBrandApiResponse;
import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.dto.CategoryDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportApiService
{
    private final CategoryService categoryService;
    private final ProductService productService;

    /*
    * 카테고리 별로 최저가격의 상품을 조회한 다음 해당 상품의 브랜드와 상품 가격, 마지막으로 총 가격을 조회하는 기능.
    */
    public CategoryBrandPriceResponse lowestPriceProductByCategory()
    {
        int totalPrice = 0;
        List<CategoryDto> categories = categoryService.findAll();

        List<ProductInfoDto> productInfos  = new ArrayList<>();

        for (CategoryDto category : categories)
        {
            ProductInfoDto productInfoDto = productService.getLowestPriceProductByCategory(category.getId());
            productInfos.add(productInfoDto);

            totalPrice += productInfoDto.getPrice();
        }
        return new CategoryBrandPriceResponse(totalPrice, productInfos);
    }

    /*
    * 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
    * */
    public LowestBrandInfoDto getLowestPriceBrand()
    {
        Brand brand = productService.getLowestPriceBrandByBrandId();

        List<LowestBrandProductInfoDto> lowestBrandProductInfoDtos = brand.getProducts().stream()
            .map(product -> new LowestBrandProductInfoDto(product.getCategory().getName(), product.getPrice()))
            .toList();

        int totalPrice = lowestBrandProductInfoDtos.stream()
            .mapToInt(LowestBrandProductInfoDto::getPrice)
            .sum();

        return new LowestBrandInfoDto(brand.getName(), totalPrice, lowestBrandProductInfoDtos);
    }

    /*
    * 카테고리 이름으로 최저 가격의 상품과 최고 가격의 상품을 조회하는 기능
    */
    public ProductInfoWithBrandApiResponse LowestAndHighestPriceProductByCategoryName(String categoryName)
    {
        return productService.getLowestPriceProductByCategoryName(categoryName);
    }


}
