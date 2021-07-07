package com.example.praticaspringboot.controllers;

import com.example.praticaspringboot.dto.categories.CategoryDTO;
import com.example.praticaspringboot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(categoryDTO));
    }
}
