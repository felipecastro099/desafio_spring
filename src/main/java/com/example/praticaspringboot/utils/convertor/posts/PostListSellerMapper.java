package com.example.praticaspringboot.utils.convertor.posts;

import com.example.praticaspringboot.dto.post.PostListSellerDTO;
import com.example.praticaspringboot.dto.post.PostPromoDTO;
import com.example.praticaspringboot.entities.Post;
import com.example.praticaspringboot.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class PostListSellerMapper {
    public static PostListSellerDTO toDto(Seller seller, List<Post> posts) {
        return new PostListSellerDTO(seller.getId(), seller.getName(), toList(posts));
    }

    public static List<PostPromoDTO> toList(List<Post> list) {
        List<PostPromoDTO> posts = new ArrayList<>();

        list.forEach(post -> {
            posts.add(PostPromoMapper.toDto(post, post.getProduct()));
        });

        return posts;
    }
}
