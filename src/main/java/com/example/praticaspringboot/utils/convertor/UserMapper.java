package com.example.praticaspringboot.utils.convertor;

import com.example.praticaspringboot.dto.users.UserDTO;
import com.example.praticaspringboot.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDTO toDto(User entitiy) {
        return new UserDTO(entitiy.getId(), entitiy.getName());
    }

    public static User toEntity(UserDTO dto){
        List<User> users = new ArrayList<>();
        return new User(dto.getUserID(), dto.getUserName(), users);
    }
}
