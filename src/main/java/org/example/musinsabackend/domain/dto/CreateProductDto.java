package org.example.musinsabackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductDto
{
    private Long brandId;
    private Long categoryId;
    private int price;
}
