package com.example.praticaspringboot.controllers;

import com.example.praticaspringboot.dto.users.UserDTO;
import com.example.praticaspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Long userId, @PathVariable Long userIdToFollow) {
        userService.follow(userId, userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<?> count(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.countFollow(userId));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> followers(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.followers(userId));
    }
}
