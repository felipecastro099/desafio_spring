package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.categories.CategoryDTO;
import com.example.praticaspringboot.entities.ProductCategory;
import com.example.praticaspringboot.repositories.CategoryRepository;
import com.example.praticaspringboot.utils.convertor.categories.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO create(CategoryDTO category) {
        ProductCategory productCategory = CategoryMapper.toEntity(category);

        categoryRepository.create(productCategory);

        return CategoryMapper.toDto(productCategory);
    }
}
