package com.example.praticaspringboot.utils.convertor.posts;

import com.example.praticaspringboot.dto.post.PostDTO;
import com.example.praticaspringboot.entities.*;
import com.example.praticaspringboot.utils.convertor.categories.ProductCategoryMapper;
import com.example.praticaspringboot.utils.convertor.pruducts.ProductMapper;
import com.example.praticaspringboot.utils.generators.GenereteID;

public class PostMapper {

    public static PostDTO toDto(Post entity, ProductCategory category, Product product) {
        return new PostDTO(entity.getSeller().getId(), entity.getId(), entity.getDate(), ProductMapper.toDto(product), ProductCategoryMapper.toDto(category).getCategory(), product.getPrice());
    }

    public static Post toEntity(PostDTO dto, Seller seller, Product product){
        return new Post(GenereteID.generateIDPost(),dto.getDate(), seller, product);
    }
}
