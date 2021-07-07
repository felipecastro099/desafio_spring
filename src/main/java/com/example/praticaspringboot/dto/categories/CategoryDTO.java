package com.example.praticaspringboot.dto.categories;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryDTO {
    private Long categoryId;
    @NotNull(message = "CategoryName não pode estar vazio.")
    @NotEmpty(message = "categoryName é obrigatorio.")
    private String categoryName;

    public CategoryDTO(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
