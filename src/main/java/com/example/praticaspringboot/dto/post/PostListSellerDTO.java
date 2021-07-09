package com.example.praticaspringboot.dto.post;

import java.util.List;

public class PostListSellerDTO {
    private Long userId;
    private String userName;
    private List<PostPromoDTO> posts;

    public PostListSellerDTO(Long userId, String userName, List<PostPromoDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<PostPromoDTO> getPosts() {
        return posts;
    }
}
