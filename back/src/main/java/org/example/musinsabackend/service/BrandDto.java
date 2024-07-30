package org.example.musinsabackend.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.musinsabackend.domain.Brand;

@Getter
@Setter
@RequiredArgsConstructor
public class BrandDto
{
    private Long id;
    private String name;

    public BrandDto(Brand brand)
    {
        this.id = brand.getId();
        this.name = brand.getName();
    }
}
