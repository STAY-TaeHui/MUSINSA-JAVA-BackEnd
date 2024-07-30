package org.example.musinsabackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductInfoDto
{
    private String brandName;
    private int price;
    private String categoryName;
}
