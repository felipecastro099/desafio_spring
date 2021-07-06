package com.example.praticaspringboot.dto.users;

public class UserDTO {
    private Long userID;
    private String userName;

    public UserDTO(Long userID, String userName) {
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
