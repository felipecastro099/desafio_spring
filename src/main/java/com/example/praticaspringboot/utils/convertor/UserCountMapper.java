package com.example.praticaspringboot.utils.convertor;

import com.example.praticaspringboot.dto.users.UserCountDTO;
import com.example.praticaspringboot.entities.User;

public class UserCountMapper {

    public static UserCountDTO toDto(User entitiy) {
        return new UserCountDTO(entitiy.getId(), entitiy.getName(), entitiy.getFollowers().size());
    }
}
