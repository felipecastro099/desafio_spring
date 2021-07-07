package com.example.praticaspringboot.utils.convertor.categories;

import com.example.praticaspringboot.dto.categories.ProductCategoryDTO;
import com.example.praticaspringboot.entities.ProductCategory;

public class ProductCategoryMapper {
    public static ProductCategoryDTO toDto(ProductCategory entity) {
        return new ProductCategoryDTO(entity.getId());
    }
}
