package com.example.praticaspringboot.dto.buyers;

public class BuyerDTO {
    private Long userID;
    private String userName;

    public BuyerDTO(Long userID, String userName) {
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
