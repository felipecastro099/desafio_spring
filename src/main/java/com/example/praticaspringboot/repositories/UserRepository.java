package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.dto.users.UserDTO;
import com.example.praticaspringboot.entities.User;
import com.example.praticaspringboot.utils.convertor.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public UserDTO create(UserDTO userDTO) {
        users.add(UserMapper.toEntity(userDTO));

        return userDTO;
    }

    public User findById(Long id) {
        Optional<User> user = users.stream().filter(v -> v.getId() == id).findFirst();

        return user.orElse(null);
    }

    public void follow(User user, User userToFollow) {
        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);
    }
}
