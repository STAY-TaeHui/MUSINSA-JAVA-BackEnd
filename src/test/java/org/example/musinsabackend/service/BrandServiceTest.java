package org.example.musinsabackend.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.dto.CreateBrandDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BrandServiceTest
{
    @Autowired
    private BrandService brandService;

    @DisplayName("브랜드 생성 테스트 성공")
    @Test
    void createBrand_withValidData_returnsBrandId() {
        CreateBrandDto createBrandDto = new CreateBrandDto();
        createBrandDto.setBrandName("Adidas");

        Long createdBrandId = brandService.createBrand(createBrandDto);

        assertNotNull(createdBrandId);
    }

    @DisplayName("브랜드 생성 테스트 - 브랜드 이름 null일 때")
    @Test
    void createBrand_withNullBrandName_throwsException() {
        CreateBrandDto createBrandDto = new CreateBrandDto();
        createBrandDto.setBrandName(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            brandService.createBrand(createBrandDto);
        });

        assertEquals("Brand name is Empty", exception.getMessage());
    }

    @DisplayName("브랜드 생성 테스트 - 브랜드 이름이 빈 문자열일 때")
    @Test
    void createBrand_withEmptyBrandName_throwsException() {
        CreateBrandDto createBrandDto = new CreateBrandDto();
        createBrandDto.setBrandName("");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            brandService.createBrand(createBrandDto);
        });

        assertEquals("Brand name is Empty", exception.getMessage());
    }

    @DisplayName("브랜드 조회 테스트 - 유효한 브랜드 ID")
    @Test
    void findOne() {
        CreateBrandDto createBrandDto = new CreateBrandDto();
        createBrandDto.setBrandName("Nike");
        Long createdBrandId = brandService.createBrand(createBrandDto);

        Brand brand = brandService.findOne(createdBrandId);

        assertNotNull(brand);
        assertEquals("Nike", brand.getName());
    }

    @DisplayName("브랜드 조회 테스트 - 존재하지 않는 브랜드 ID")
    @Test
    void findOneId_throwsException() {
        Long invalidBrandId = 999L;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            brandService.findOne(invalidBrandId);
        });

        assertEquals("해당 브랜드가 존재하지 않습니다.", exception.getMessage());
    }

    @DisplayName("브랜드 조회 테스트 - 모든 브랜드 조회")
    @Test
    void getAllBrands_returnsAllBrands() {
        List<Brand> allBrands = brandService.getAllBrands();

        allBrands.size();

    }
}