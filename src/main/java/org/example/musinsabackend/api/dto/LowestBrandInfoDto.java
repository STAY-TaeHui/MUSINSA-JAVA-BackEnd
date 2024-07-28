package org.example.musinsabackend.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LowestBrandInfoDto
{
    private Long brandId;
    private String brandName;
    private Long totalPrice;
    private List<LowestBrandProductInfoDto> lowestBrandProductInfoDtos;

    public LowestBrandInfoDto(Long brandId, String brandName, Long totalPrice)
    {
        this.brandId = brandId;
        this.brandName = brandName;
        this.totalPrice = totalPrice;
    }

    public void addAllLowestBrandProductInfoDtos(List<LowestBrandProductInfoDto> lowestBrandProductInfoDtos)
    {
        if(lowestBrandProductInfoDtos.isEmpty())
            return;

        this.lowestBrandProductInfoDtos = new ArrayList<>(lowestBrandProductInfoDtos);
    }
}
