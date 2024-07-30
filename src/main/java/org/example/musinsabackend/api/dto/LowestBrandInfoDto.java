package org.example.musinsabackend.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LowestBrandInfoDto
{
    private String brandName;
    private int totalPrice;
    private List<LowestBrandProductInfoDto> productInfos;

    public LowestBrandInfoDto(String brandName, int totalPrice, List<LowestBrandProductInfoDto> lowestBrandProductInfoDtos)
    {
        this.brandName = brandName;
        this.totalPrice = totalPrice;
        this.productInfos = new ArrayList<>(lowestBrandProductInfoDtos);
    }
}
