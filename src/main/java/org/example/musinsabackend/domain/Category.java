package org.example.musinsabackend.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String name;

    //TODO
    // delete_flag

    public Category createCategory(String name)
    {
        Category category = new Category();
        category.name = name;
        return category;
    }
}
