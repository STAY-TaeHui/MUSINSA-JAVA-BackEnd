package org.example.musinsabackend.service;

import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.example.musinsabackend.domain.Category;
import org.example.musinsabackend.repository.CategoryJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryService
{
    private final CategoryJpaRepository categoryJpaRepository;

    public List<Category> getCategories()
    {
        return categoryJpaRepository.findAll();

    }
}
