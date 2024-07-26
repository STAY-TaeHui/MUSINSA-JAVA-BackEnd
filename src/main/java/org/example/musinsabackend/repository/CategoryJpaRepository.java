package org.example.musinsabackend.repository;

import java.util.List;

import org.example.musinsabackend.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long>
{
}
