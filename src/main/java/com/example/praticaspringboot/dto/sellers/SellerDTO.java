package com.example.praticaspringboot.dto.sellers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SellerDTO {
    private Long userID;
    @NotNull(message = "O userName não pode ser nulo.")
    @NotEmpty(message = "O userName não pode está vazio.")
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
