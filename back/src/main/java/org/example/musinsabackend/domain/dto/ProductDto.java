package org.example.musinsabackend.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.musinsabackend.domain.Product;
import org.example.musinsabackend.service.BrandDto;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDto
{
    private Long id;
    private int price;

    private BrandDto brand;

    private CategoryDto category;

    public ProductDto(Product product)
    {
        this.id = product.getId();
        this.price = product.getPrice();

        this.brand = new BrandDto(product.getBrand());
        this.category = new CategoryDto(product.getCategory());
    }
}
