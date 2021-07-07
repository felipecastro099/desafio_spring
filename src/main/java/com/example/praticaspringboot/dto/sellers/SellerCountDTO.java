package com.example.praticaspringboot.dto.sellers;

public class SellerCountDTO {
    private Long userID;
    private String userName;
    private Integer followers_count;

    public SellerCountDTO(Long userID, String userName, Integer followers_count) {
        this.userID = userID;
        this.userName = userName;
        this.followers_count = followers_count;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getFollowers_count() {
        return followers_count;
    }
}
