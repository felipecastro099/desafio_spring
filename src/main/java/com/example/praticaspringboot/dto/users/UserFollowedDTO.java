package com.example.praticaspringboot.dto.users;

import java.util.List;

public class UserFollowedDTO  {
    private Long userID;
    private String userName;
    private List<UserDTO> followed;

    public UserFollowedDTO(Long userID, String userName, List<UserDTO> followed) {
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

    public List<UserDTO> getFollowed() {
        return followed;
    }
}
