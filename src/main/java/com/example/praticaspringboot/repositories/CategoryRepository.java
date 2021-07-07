package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.entities.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    List<ProductCategory> categories = new ArrayList<>();

    public ProductCategory create(ProductCategory category) {
        categories.add(category);

        return category;
    }

    public ProductCategory findById(Long id) {
        Optional<ProductCategory> result = categories.stream().filter(category -> category.getId() == id).findFirst();

        return result.orElse(null);
    }
}
