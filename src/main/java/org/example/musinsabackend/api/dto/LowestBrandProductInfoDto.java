package org.example.musinsabackend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LowestBrandProductInfoDto
{
    private String categoryName;
    private int price;
}
