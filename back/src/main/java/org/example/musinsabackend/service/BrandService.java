package org.example.musinsabackend.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.domain.Brand;
import org.example.musinsabackend.domain.dto.CreateBrandDto;
import org.example.musinsabackend.domain.dto.UpdateBrandDto;
import org.example.musinsabackend.repository.BrandJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService
{
    private final BrandJpaRepository brandJpaRepository;

    public Long createBrand(CreateBrandDto createBrandDto)
    {
        return brandJpaRepository.save(Brand.createBrand(createBrandDto)).getId();
    }

    public Brand findEntity(Long brandId)
    {
        return brandJpaRepository.findById(brandId).orElseThrow(() -> new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));
    }

    public BrandDto findOne(Long brandId)
    {
        Brand brand = brandJpaRepository.findById(brandId).orElseThrow(() -> new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));
        return new BrandDto(brand);
    }

    public List<BrandDto> getAllBrands()
    {
        return brandJpaRepository.findAll().stream()
            .map(BrandDto::new)
            .toList();
    }

    public void deleteBrand(Long id)
    {
        Brand brand = brandJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));

        if(!brand.getProducts().isEmpty())
            throw new IllegalArgumentException("해당 브랜드에 속한 상품이 존재하여 삭제할 수 없습니다.");

        brandJpaRepository.deleteById(id);
    }

    public Long updateBrand(Long id, UpdateBrandDto dto)
    {
        Brand brand = brandJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 브랜드가 존재하지 않습니다."));

        brand.updateBrand(dto);

        return brand.getId();
    }
}
