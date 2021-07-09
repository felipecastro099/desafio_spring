package com.example.praticaspringboot.utils.convertor.posts;

import com.example.praticaspringboot.dto.post.PostPromoDTO;
import com.example.praticaspringboot.entities.Post;
import com.example.praticaspringboot.entities.Product;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.convertor.pruducts.ProductMapper;
import com.example.praticaspringboot.utils.generators.GenereteID;

public class PostPromoMapper {
    public static PostPromoDTO toDto(Post entity, Product product) {
        return new PostPromoDTO(entity.getSeller().getId(), entity.getId(), entity.getDate(), ProductMapper.toDto(product), product.getCategory().getId(), product.getPrice(), product.getHasPromo(), product.getDiscount());
    }

    public static Post toEntity(PostPromoDTO dto, Seller seller, Product product){
        return new Post(GenereteID.generateIDPost(),dto.getDate(), seller, product);
    }
}
