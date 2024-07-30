package org.example.musinsabackend.api.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.musinsabackend.api.dto.ProductInfoDto;

@Getter
@Setter
@AllArgsConstructor
public class CategoryBrandPriceResponse
{
    List<ProductInfoDto> productInfos;
    private int totalPrice;

    public CategoryBrandPriceResponse(int totalPrice, List<ProductInfoDto> productInfos)
    {
        this.productInfos = new ArrayList<>(productInfos);
        this.totalPrice = totalPrice;
    }
}
