package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.users.UserCountDTO;
import com.example.praticaspringboot.dto.users.UserDTO;
import com.example.praticaspringboot.dto.users.UserFollowersDTO;
import com.example.praticaspringboot.entities.User;
import com.example.praticaspringboot.repositories.UserRepository;
import com.example.praticaspringboot.utils.convertor.UserCountMapper;
import com.example.praticaspringboot.utils.convertor.UserFollowersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        return userRepository.create(userDTO);
    }

    public void follow(Long userId, Long userIdToFollow) {
        User user = userRepository.findById(userId);
        User userToFollow = userRepository.findById(userIdToFollow);

        if (user != null && userToFollow != null) {
            userRepository.follow(user, userToFollow);
        }
    }

    public UserCountDTO countFollow(Long id) {
        User user = userRepository.findById(id);

        if (user != null) {
            return UserCountMapper.toDto(user);
        }

        return null;
    }

    public UserFollowersDTO followers(Long id) {
        User user = userRepository.findById(id);

        if (user != null) {
            return UserFollowersMapper.toDto(user);
        }

        return null;
    }
}
