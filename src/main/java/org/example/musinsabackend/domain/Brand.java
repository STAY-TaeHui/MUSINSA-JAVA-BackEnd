package org.example.musinsabackend.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.musinsabackend.domain.dto.CreateBrandDto;
import org.example.musinsabackend.domain.dto.UpdateBrandDto;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", nullable = false)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String name;

    //TODO
    // delete_flag

    @OneToMany(mappedBy = "brand")
    List<Product> products;

    public static Brand createBrand(CreateBrandDto createBrandDto)
    {
        if (createBrandDto.getBrandName() == null || createBrandDto.getBrandName().isEmpty())
        {
            throw new IllegalArgumentException("Brand name is Empty");
        }
        Brand brand = new Brand();
        brand.name = createBrandDto.getBrandName();
        return brand;
    }

    public void addProducts(Product product)
    {
        products.add(product);
    }

    public void updateBrand(UpdateBrandDto dto)
    {
        this.name = dto.getBrandName();
    }
}
