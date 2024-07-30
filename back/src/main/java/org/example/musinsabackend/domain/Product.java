package org.example.musinsabackend.domain;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musinsabackend.domain.dto.ProductDto;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "product_price", nullable = false)
    private int price;

    public ProductDto toDto()
    {
        return new ProductDto(id, price);
    }

    public static Product createProduct(Brand brand, Category category, int price)
    {
        Product product = new Product();
        product.brand = brand;
        product.category = category;
        product.price = price;

        brand.addProducts(product);

        return product;
    }

    public void updateProduct(Brand brand, Category category, int price)
    {
        this.brand = brand;
        this.category = category;
        this.price = price;
    }
}
