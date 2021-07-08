package com.example.praticaspringboot.dto.buyers;

import com.example.praticaspringboot.dto.post.PostListDTO;

import java.util.List;

public class BuyerListPostDTO {
    private Long userId;
    private List<PostListDTO> posts;

    public BuyerListPostDTO(Long userId, List<PostListDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public List<PostListDTO> getPosts() {
        return posts;
    }
}
