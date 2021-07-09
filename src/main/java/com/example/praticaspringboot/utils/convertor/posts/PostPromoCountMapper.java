package com.example.praticaspringboot.utils.convertor.posts;

import com.example.praticaspringboot.dto.post.PostPromoCountDTO;
import com.example.praticaspringboot.entities.Seller;

public class PostPromoCountMapper {
    public static PostPromoCountDTO toDto (Seller seller, Integer size) {
        return new PostPromoCountDTO(seller.getId(), seller.getName(), size);
    }
}
