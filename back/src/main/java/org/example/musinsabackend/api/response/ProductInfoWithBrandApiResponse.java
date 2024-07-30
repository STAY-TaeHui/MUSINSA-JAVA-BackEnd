package org.example.musinsabackend.api.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.api.dto.ProductPriceAndBrandNameDto;

@Data
@RequiredArgsConstructor
public class ProductInfoWithBrandApiResponse
{
    private String categoryName;

    private List<ProductPriceAndBrandNameDto> lowestPrice;

    private List<ProductPriceAndBrandNameDto> highestPrice;

    public ProductInfoWithBrandApiResponse(String categoryName,
                                           List<ProductPriceAndBrandNameDto> lowestPrice,
                                           List<ProductPriceAndBrandNameDto> highestPrice)
    {
        this.categoryName = categoryName;
        this.lowestPrice = new ArrayList<>(lowestPrice);
        this.highestPrice = new ArrayList<>(highestPrice);
    }
}
