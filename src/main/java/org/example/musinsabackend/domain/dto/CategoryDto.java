package org.example.musinsabackend.domain.dto;

import lombok.Getter;
import org.example.musinsabackend.domain.Category;

@Getter
public class CategoryDto
{
    private final Long id;
    private final String name;

    public CategoryDto(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public CategoryDto(Category category)
    {
        this.id = category.getId();
        this.name = category.getName();
    }
}
