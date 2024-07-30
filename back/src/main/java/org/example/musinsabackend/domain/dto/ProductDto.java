package org.example.musinsabackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto
{
    private final Long id;
    private final int price;
}
