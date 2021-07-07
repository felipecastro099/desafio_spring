package com.example.praticaspringboot.controllers;

import com.example.praticaspringboot.dto.post.PostDTO;
import com.example.praticaspringboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/newpost")
    public ResponseEntity<?> createPost(@RequestBody @Valid PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(postDTO));
    }
}
