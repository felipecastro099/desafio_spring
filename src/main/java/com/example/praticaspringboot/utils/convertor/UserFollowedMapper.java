package com.example.praticaspringboot.utils.convertor;

import com.example.praticaspringboot.dto.users.UserDTO;
import com.example.praticaspringboot.dto.users.UserFollowedDTO;
import com.example.praticaspringboot.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserFollowedMapper {
    public static UserFollowedDTO toDto(User entitiy) {
        return new UserFollowedDTO(entitiy.getId(), entitiy.getName(), userDTOList(entitiy.getFollowers()));
    }

    public static List<UserDTO> userDTOList(List<User> users) {
        List<UserDTO> list = new ArrayList<>();

        users.forEach(user -> list.add(UserMapper.toDto(user)));

        return list;
    }
}
