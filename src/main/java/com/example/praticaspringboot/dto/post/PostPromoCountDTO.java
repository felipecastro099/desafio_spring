package com.example.praticaspringboot.dto.post;

public class PostPromoCountDTO {
    private Long userId;
    private String userName;
    private Integer promoproducts_count;

    public PostPromoCountDTO(Long userId, String userName, Integer promoproducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = promoproducts_count;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getPromoproducts_count() {
        return promoproducts_count;
    }
}
