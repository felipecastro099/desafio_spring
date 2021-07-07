package com.example.praticaspringboot.dto.buyers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BuyerDTO {
    private Long userID;
    @NotNull(message = "O userName não pode ser nulo.")
    @NotEmpty(message = "O userName não pode está vazio.")
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
