package com.example.praticaspringboot.utils.convertor.categories;

import com.example.praticaspringboot.dto.categories.CategoryDTO;
import com.example.praticaspringboot.entities.ProductCategory;
import com.example.praticaspringboot.utils.generators.GenereteID;

public class CategoryMapper {
    public static CategoryDTO toDto(ProductCategory category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    public static ProductCategory toEntity(CategoryDTO categoryDTO) {
        return new ProductCategory(GenereteID.generateIDCategory(), categoryDTO.getCategoryName());
    }
}
