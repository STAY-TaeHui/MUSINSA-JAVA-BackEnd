package org.example.musinsabackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductPriceAndBrandNameDto
{
    private String brandName;
    private int price;

}
