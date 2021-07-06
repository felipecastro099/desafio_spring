package com.example.praticaspringboot.dto.users;

import java.util.List;

public class UserFollowersDTO {
    private Long userId;
    private String userName;
    private List<UserDTO> followers;

    public UserFollowersDTO(Long userId, String userName, List<UserDTO> followers) {
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

    public List<UserDTO> getFollowers() {
        return followers;
    }
}
