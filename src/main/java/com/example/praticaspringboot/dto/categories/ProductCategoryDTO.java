package com.example.praticaspringboot.dto.categories;

public class ProductCategoryDTO {
    private Long category;

    public ProductCategoryDTO(Long category) {
        this.category = category;
    }

    public Long getCategory() {
        return category;
    }
}
