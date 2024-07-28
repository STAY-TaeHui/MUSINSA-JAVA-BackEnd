package org.example.musinsabackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.musinsabackend.api.dto.ProductInfoWithBrandApiResponse;
import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.domain.Product;
import org.example.musinsabackend.repository.ProductJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest
{
    @Mock
    private ProductJpaRepository productJpaRepository;

    @Mock
    Category category;

    @Mock
    Brand brand;

    @Mock
    Brand brand2;

    @Mock
    Product product1;

    @Mock
    Product product2;

    @BeforeEach
    void setup()
    {
        //category를 mock으로 만들어서 넣어준다.
        when(category.getId()).thenReturn(1L);
        when(category.getName()).thenReturn("카테고리1");

        when(brand.getId()).thenReturn(1L);
        when(brand.getName()).thenReturn("브랜드1");

        when(brand2.getId()).thenReturn(2L);
        when(brand2.getName()).thenReturn("브랜드2");

        //product를 mock으로 만들어서 넣어준다.
        when(product1.getId()).thenReturn(1L);
        when(product1.getPrice()).thenReturn(1000);
        when(product1.getCategory()).thenReturn(category);
        when(product1.getBrand()).thenReturn(brand);

        when(product2.getId()).thenReturn(2L);
        when(product2.getPrice()).thenReturn(5000);
        when(product2.getCategory()).thenReturn(category);
        when(product2.getBrand()).thenReturn(brand2);
    }

    @Test
    void getProducts()
    {
    }

    @DisplayName("카테고리 ID로 가격이 가장 낮은 상품을 조회하는 테스트")
    @Test
    void getLowestPriceProductByCategoryId()
    {
        // given
        when(productJpaRepository.findTopByCategoryOrderByPriceWithBrand(1L)).thenReturn(
            Optional.of(new ProductInfoWithBrandApiResponse(product1.getBrand().getName(), product1.getPrice())).get()
        );

        // when
//        ProductInfoWithBrandApi productInfoWithBrandApi = new ProductInfoWithBrandApi(
//            productJpaRepository.findTopByCategoryOrderByPrice(category).orElseThrow()
//        );

        // then
//        assertThat(productInfoWithBrandApi.getPrice()).isEqualTo(1000);
    }

    @Test
    void getProductInfoWithBrand()
    {
    }
}