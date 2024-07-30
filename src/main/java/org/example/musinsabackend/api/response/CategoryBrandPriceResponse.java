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
    List<ProductInfoDto> productInfo;
    private int totalPrice;

    public CategoryBrandPriceResponse(int totalPrice, List<ProductInfoDto> productInfo)
    {
        this.productInfo = new ArrayList<>(productInfo);
        this.totalPrice = totalPrice;
    }
}
