package com.example.praticaspringboot.utils.convertor.posts;

import com.example.praticaspringboot.dto.post.PostListDTO;
import com.example.praticaspringboot.entities.Post;
import com.example.praticaspringboot.entities.Product;
import com.example.praticaspringboot.entities.ProductCategory;
import com.example.praticaspringboot.utils.convertor.categories.ProductCategoryMapper;
import com.example.praticaspringboot.utils.convertor.pruducts.ProductMapper;

public class PostListMapper {
    public static PostListDTO toDto(Post entity, ProductCategory category, Product product) {
        return new PostListDTO(entity.getId(), entity.getDate(), ProductMapper.toDto(product), ProductCategoryMapper.toDto(category).getCategory(), product.getPrice());
    }
}
