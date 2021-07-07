package com.example.praticaspringboot.dto.buyers;

import com.example.praticaspringboot.dto.sellers.SellerDTO;

import java.util.List;

public class BuyerFollowedDTO {
    private Long userID;
    private String userName;
    private List<SellerDTO> followed;

    public BuyerFollowedDTO(Long userID, String userName, List<SellerDTO> followed) {
        this.userID = userID;
        this.userName = userName;
        this.followed = followed;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public List<SellerDTO> getFollowed() {
        return followed;
    }
}
