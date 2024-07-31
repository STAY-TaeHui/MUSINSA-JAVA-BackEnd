package org.example.musinsabackend.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.ProductInfoDto;
import org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto;
import org.example.musinsabackend.api.response.ProductInfoWithBrandApiResponse;
import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.domain.Product;
import org.example.musinsabackend.domain.dto.CreateProductDto;
import org.example.musinsabackend.domain.dto.ProductDto;
import org.example.musinsabackend.repository.ProductJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductJpaRepository productJpaRepository;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public List<Product> getProducts()
    {
        return productJpaRepository.findAll();
    }

    public Product findEntity(Long id)
    {
        return productJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
    }

    public ProductDto findOne(Long id)
    {
        Product product = productJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        return new ProductDto(product);
    }

    /*
    * 카테고리 아이디에 해당하는 상품들 중에서 가격이 가장 낮은 상품을 조회하는 기능
    * @param categoryId 카테고리 아이디
    * @return 가격이 가장 낮은 상품
    */
    public ProductInfoDto getLowestPriceProductByCategory(Long categoryId)
    {
        Optional<Product> product = productJpaRepository.findTopByCategory_IdOrderByPrice(categoryId);
        product.orElseThrow(() -> new IllegalArgumentException("해당 카테고리에 상품이 존재하지 않습니다."));

        return new ProductInfoDto(
            product.get().getBrand().getName(),
            product.get().getPrice(),
            product.get().getCategory().getName()
        );
    }

    /*
    * 브랜드의 모든 상품 금액의 합계 중 최저가인 브랜드를 조회
    * 해당 브랜드의 모든 상품의 카테고리 이름과 가격 그리고 총액을 반환
    * @return 브랜드의 모든 상품의 합계 중 최저가인 브랜드의 카테고리와 상품의 가격 및 총 합계
    */
    public Brand getLowestPriceBrandByBrandId()
    {
        return productJpaRepository.findTopBrandIdByBrandIdOrderByPrice().orElseThrow(() -> new RuntimeException("데이터 조회중 오류가 발생했습니다."));
    }

    /*
    * 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
    * @param categoryName 카테고리 이름
    * @return 카테고리 이름으로 조회한 모든 상품
    * */
    public ProductInfoWithBrandApiResponse getLowestPriceProductByCategoryName(String categoryName)
    {
        Optional<List<ProductPriceAndBrandNameDto>> lowestPriceProducts = productJpaRepository.findTopByCategoryNameOrderByPriceWithBrand(categoryName);
        Optional<List<ProductPriceAndBrandNameDto>> highestPriceProducts = productJpaRepository.findTopByCategoryNameOrderByPriceWithBrandDesc(categoryName);

        lowestPriceProducts.orElseThrow();
        return new ProductInfoWithBrandApiResponse(
            categoryName,
            lowestPriceProducts.orElse(null),
            highestPriceProducts.orElse(null)
        );
    }

    /*
    * 상품 생성
    * @param createProductDto 생성할 상품 정보
    * @return 생성된 상품의 아이디
    * */
    public Long createProduct(CreateProductDto createProductDto)
    {
        Brand brand = brandService.findEntity(createProductDto.getBrandId());
        Category category = categoryService.findEntity(createProductDto.getCategoryId());

        Product savedProduct = productJpaRepository.save(
            Product.createProduct(brand, category, createProductDto.getPrice())
        );
        brand.addProducts(savedProduct);

        return savedProduct.getId();
    }

    /*
    * 상품 삭제
    * @param id 삭제할 상품 아이디
    * @return 삭제된 상품의 아이디
    * */
    public Long deleteProduct(Long id)
    {
        Product product = productJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));
        productJpaRepository.deleteById(id);

        return product.getId();
    }

    /*
    * 상품 수정
    * @param id 수정할 상품 아이디
    * @param dto 수정할 상품 정보
    * @return 수정된 상품의 아이디
    * */
    @Transactional
    public Long updateProduct(Long id, CreateProductDto dto)
    {
        Product product = productJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 상품이 존재하지 않습니다."));

        Brand brand = brandService.findEntity(dto.getBrandId());
        Category category = categoryService.findEntity(dto.getCategoryId());

        product.updateProduct(brand, category, dto.getPrice());

        return product.getId();
    }

    public List<ProductDto> findAll()
    {
        return productJpaRepository.findAll().stream()
            .map(ProductDto::new)
            .toList();
    }
}
