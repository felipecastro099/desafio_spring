package com.example.praticaspringboot.dto.sellers;

public class SellerDTO {
    private Long userID;
    private String userName;

    public SellerDTO(Long userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
}
