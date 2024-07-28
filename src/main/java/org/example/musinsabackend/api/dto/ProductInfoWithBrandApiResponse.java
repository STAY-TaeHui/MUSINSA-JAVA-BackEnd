package org.example.musinsabackend.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductInfoWithBrandApiResponse
{
    private String categoryName;

    private List<ProductPriceAndBrandNameDto> lowestPriceProductAndBrandNameDto;

    private List<ProductPriceAndBrandNameDto> highestPriceProductAndBrandNameDto;

    public ProductInfoWithBrandApiResponse(String categoryName,
                                           List<ProductPriceAndBrandNameDto> lowestPriceProductAndBrandNameDto,
                                           List<ProductPriceAndBrandNameDto> highestPriceProductAndBrandNameDto)
    {
        this.categoryName = categoryName;
        this.lowestPriceProductAndBrandNameDto = new ArrayList<>(lowestPriceProductAndBrandNameDto);
        this.highestPriceProductAndBrandNameDto = new ArrayList<>(highestPriceProductAndBrandNameDto);
    }
}
