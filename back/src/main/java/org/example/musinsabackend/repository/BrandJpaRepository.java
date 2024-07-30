package org.example.musinsabackend.repository;

import org.example.musinsabackend.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<Brand, Long>
{
}
