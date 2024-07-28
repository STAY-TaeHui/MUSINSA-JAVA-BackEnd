package org.example.musinsabackend.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.LowestBrandInfoDto;
import org.example.musinsabackend.api.dto.LowestBrandProductInfoDto;
import org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto;
import org.example.musinsabackend.api.dto.ProductInfoWithBrandApiResponse;
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
    public ProductPriceAndBrandNameDto getLowestPriceProductByCategoryId(Long categoryId)
    {
        return productJpaRepository.findTopByCategoryOrderByPriceWithBrand(categoryId);
    }

    /*
    * 브랜드의 모든 상품 금액의 합계 중 최저가인 브랜드를 조회
    * 해당 브랜드의 모든 상품의 카테고리 이름과 가격 그리고 총액을 반환
    * @return 브랜드의 모든 상품의 합계 중 최저가인 브랜드의 카테고리와 상품의 가격 및 총 합계
    */
    public LowestBrandInfoDto getLowestPriceBrandByBrandId()
    {
        return productJpaRepository.findTopBrandIdByBrandIdOrderByPrice().get();
    }

    /*
    * 브랜드 아이디로 해당 브랜드의 모든 상품 정보 조회
    * @param brandId 브랜드 아이디
    * @return 브랜드 아이디로 조회한 모든 상품 정보
    * */
    public List<LowestBrandProductInfoDto> getProductInfoByBrandId(Long brandId)
    {
        return productJpaRepository.findByBrand_Id(brandId).get();
    }

    /*
    * 카테고리 이름으로 모든 상품 조회
    * @param categoryName 카테고리 이름
    * @return 카테고리 이름으로 조회한 모든 상품
    * */
    public List<Product> getProductsByCategoryName(String categoryName)
    {
        return productJpaRepository.findByCategory_Name(categoryName).get();
    }

    public ProductInfoWithBrandApiResponse getLowestPriceProductByCategoryName(String categoryName)
    {
        Optional<List<ProductPriceAndBrandNameDto>> lowestPriceProducts = productJpaRepository.findTopByCategoryNameOrderByPriceWithBrand(categoryName);
        Optional<List<ProductPriceAndBrandNameDto>> highestPriceProducts = productJpaRepository.findTopByCategoryNameOrderByPriceWithBrandDesc(categoryName);

        ProductInfoWithBrandApiResponse response = new ProductInfoWithBrandApiResponse(
            categoryName,
            lowestPriceProducts.orElse(null),
            highestPriceProducts.orElse(null)
        );
        return response;
    }
}
