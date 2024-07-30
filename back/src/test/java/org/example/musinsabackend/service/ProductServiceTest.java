package org.example.musinsabackend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.musinsabackend.api.dto.ProductInfoDto;
import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.domain.Product;
import org.example.musinsabackend.domain.dto.CreateProductDto;
import org.example.musinsabackend.repository.CategoryJpaRepository;
import org.example.musinsabackend.repository.ProductJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ProductServiceTest
{
    @Mock
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductService productService;

    @Mock
    private CategoryJpaRepository categoryRepository;

    @Mock
    private BrandService brandService;

    @Mock
    private CategoryService categoryService;

    @Mock
    Category category_mock;

    @Mock
    Category category_mock2;

    @Mock
    Brand brand_mock;

    @Mock
    Brand brand_mock2;

    @Mock
    Product product_mock;

    @Mock
    Product product_mock2;

    @BeforeEach
    void setup()
    {
        //category를 mock으로 만들어서 넣어준다.
        when(category_mock.getId()).thenReturn(1L);
        when(category_mock.getName()).thenReturn("상의");

        when(category_mock2.getId()).thenReturn(2L);
        when(category_mock2.getName()).thenReturn("아우터");


        when(brand_mock.getId()).thenReturn(1L);
        when(brand_mock.getName()).thenReturn("A");

        when(brand_mock2.getId()).thenReturn(2L);
        when(brand_mock2.getName()).thenReturn("B");

        //product를 mock으로 만들어서 넣어준다.
        when(product_mock.getId()).thenReturn(1L);
        when(product_mock.getPrice()).thenReturn(11200);
        when(product_mock.getCategory()).thenReturn(category_mock);
        when(product_mock.getBrand()).thenReturn(brand_mock);

        when(product_mock2.getId()).thenReturn(2L);
        when(product_mock2.getPrice()).thenReturn(5500);
        when(product_mock2.getCategory()).thenReturn(category_mock);
        when(product_mock2.getBrand()).thenReturn(brand_mock2);
    }

    @DisplayName("카테고리 ID로 가격이 가장 낮은 상품을 성공적으로 조회")
    @Test
    @Transactional
    void getLowestPriceProductByCategory_Success() {
        when(categoryRepository.findById(category_mock.getId())).thenReturn(Optional.of(category_mock));
        when(productJpaRepository.findTopByCategory_IdOrderByPrice(category_mock.getId())).thenReturn(Optional.of(product_mock));

        ProductInfoDto result = productService.getLowestPriceProductByCategory(category_mock.getId());

        assertThat(result).isNotNull();
        assertThat(result.getBrandName()).isEqualTo("C");
        assertThat(result.getPrice()).isEqualTo(10000);
        assertThat(result.getCategoryName()).isEqualTo("상의");
    }

    @DisplayName("카테고리 ID로 가격이 가장 낮은 상품 조회 시 카테고리에 상품이 없을 때 예외 발생")
    @Test
    @Transactional
    void getLowestPriceProductByCategoryId_NoProductFound() {
        when(productJpaRepository.findTopByCategory_IdOrderByPrice(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getLowestPriceProductByCategory(1L))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 카테고리에 상품이 존재하지 않습니다.");
    }

    @DisplayName("상품 생성 테스트 - 유효한 데이터")
    @Test
    @Transactional
    void createProduct_withValidData_returnsProductId() {
        CreateProductDto createProductDto = new CreateProductDto(1L, 1L, 2000);
        when(brandService.findEntity(createProductDto.getBrandId())).thenReturn(brand_mock);
        when(categoryService.findEntity(createProductDto.getCategoryId())).thenReturn(category_mock);
        when(productJpaRepository.save(any(Product.class))).thenReturn(product_mock);

        Long createdProductId = productService.createProduct(createProductDto);

        assertThat(createdProductId).isEqualTo(product_mock.getId());
    }

    @DisplayName("상품 생성 테스트 - 존재하지 않는 브랜드 ID")
    @Test
    void createProduct_withInvalidBrandId_throwsException() {
        CreateProductDto createProductDto = new CreateProductDto(999L, 1L, 2000);
        when(brandService.findOne(createProductDto.getBrandId())).thenThrow(new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));

        assertThatThrownBy(() -> productService.createProduct(createProductDto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 브랜드가 존재하지 않습니다.");
    }

    @DisplayName("상품 생성 테스트 - 존재하지 않는 카테고리 ID")
    @Test
    void createProduct_withInvalidCategoryId_throwsException() {
        CreateProductDto createProductDto = new CreateProductDto(1L, 999L, 2000);
        when(categoryService.findOne(createProductDto.getCategoryId())).thenThrow(new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));

        assertThatThrownBy(() -> productService.createProduct(createProductDto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 카테고리가 존재하지 않습니다.");
    }

    @DisplayName("상품 삭제 테스트 - 유효한 상품 ID")
    @Test
    void deleteProduct_withValidId_returnsProductId() {
        Long productId = 1L;
        when(productJpaRepository.findById(productId)).thenReturn(Optional.of(product_mock));

        Long deletedProductId = productService.deleteProduct(productId);

        assertThat(deletedProductId).isEqualTo(productId);
    }

    @DisplayName("상품 삭제 테스트 - 존재하지 않는 상품 ID")
    @Test
    void deleteProduct_withInvalidId_throwsException() {
        Long invalidProductId = 999L;
        when(productJpaRepository.findById(invalidProductId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.deleteProduct(invalidProductId))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 상품이 존재하지 않습니다.");
    }

    @DisplayName("상품 수정 테스트 - 유효한 상품 ID")
    @Test
    void updateProduct_withValidId_returnsUpdatedProductId() {
        Long productId = 1L;
        CreateProductDto dto = new CreateProductDto(1L, 1L, 2000);
        when(productJpaRepository.findById(productId)).thenReturn(Optional.of(product_mock));
        when(brandService.findEntity(dto.getBrandId())).thenReturn(brand_mock);
        when(categoryService.findEntity(dto.getCategoryId())).thenReturn(category_mock);

        Long updatedProductId = productService.updateProduct(productId, dto);

        assertThat(updatedProductId).isEqualTo(productId);
    }

    @DisplayName("상품 수정 테스트 - 존재하지 않는 상품 ID")
    @Test
    void updateProduct_withInvalidId_throwsException() {
        Long invalidProductId = 999L;
        CreateProductDto dto = new CreateProductDto(1L, 1L, 2000);
        when(productJpaRepository.findById(invalidProductId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.updateProduct(invalidProductId, dto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("해당 상품이 존재하지 않습니다.");
    }

    @DisplayName("상품 정보 조회 테스트 - 유효한 상품 ID")
    @Test
    @Transactional
    void getProductInfo_withValidId_returnsProductInfo() {
        Long productId = 1L;
        when(productJpaRepository.findById(productId)).thenReturn(Optional.of(product_mock));
        when(product_mock.getBrand()).thenReturn(brand_mock);

        Product product = productService.findEntity(productId);

        assertThat(product).isNotNull();
        assertThat(product.getBrand().getName()).isEqualTo(brand_mock.getName());
    }
}