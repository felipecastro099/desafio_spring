package com.example.praticaspringboot.dto.sellers;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.entities.Buyer;

import java.util.List;

public class SellerFollowersDTO {
    private Long userId;
    private String userName;
    private List<BuyerDTO> followers;

    public SellerFollowersDTO(Long userId, String userName, List<BuyerDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<BuyerDTO> getFollowers() {
        return followers;
    }
}
