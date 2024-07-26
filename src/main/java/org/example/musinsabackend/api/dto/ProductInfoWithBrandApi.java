package org.example.musinsabackend.api.dto;

import lombok.Getter;
import org.example.musinsabackend.domain.Product;

@Getter
public class ProductInfoWithBrandApi
{
    private final String brandName;
    private final Long price;

    public ProductInfoWithBrandApi(String brandName, Long price)
    {
        this.brandName = brandName;
        this.price = price;
    }

    public ProductInfoWithBrandApi(Product product)
    {
        this.brandName = product.getBrand().getName();
        this.price = (long) product.getPrice();
    }
}
