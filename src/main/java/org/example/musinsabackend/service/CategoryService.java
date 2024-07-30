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

    public Category findOne(Long categoryId)
    {
        return categoryJpaRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));
    }
}
