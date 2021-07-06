package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.users.UserDTO;
import com.example.praticaspringboot.entities.User;
import com.example.praticaspringboot.repositories.UserRepository;
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
}
