package org.example.musinsabackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.musinsabackend.api.dto.ProductInfoDto;
import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.domain.Product;
import org.example.musinsabackend.repository.CategoryJpaRepository;
import org.example.musinsabackend.repository.ProductJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest
{
    @Mock
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryJpaRepository categoryRepository;

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
        when(category.getName()).thenReturn("상의");

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

    @DisplayName("카테고리 ID로 가격이 가장 낮은 상품을 성공적으로 조회")
    @Test
    void getLowestPriceProductByCategory_Success() {

        Category category1 = categoryRepository.findById(1L).get();

        ProductInfoDto result = productService.getLowestPriceProductByCategory(category1);

        assertThat(result).isNotNull();
        assertThat(result.getBrandName()).isEqualTo("브랜드1");
        assertThat(result.getPrice()).isEqualTo(1000);
        assertThat(result.getCategoryName()).isEqualTo("카테고리1");
    }

    @DisplayName("카테고리 ID로 가격이 가장 낮은 상품 조회 시 카테고리에 상품이 없을 때 예외 발생")
    @Test
    void getLowestPriceProductByCategoryId_NoProductFound() {
        when(productJpaRepository.findTopByCategoryOrderByPrice(category)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getLowestPriceProductByCategory(category))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 카테고리에 상품이 존재하지 않습니다.");
    }

    @Test
    void getProductInfoWithBrand()
    {
    }
}