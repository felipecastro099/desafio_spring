package com.example.praticaspringboot.controllers;

import com.example.praticaspringboot.dto.post.PostDTO;
import com.example.praticaspringboot.dto.post.PostPromoDTO;
import com.example.praticaspringboot.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/newpromopost")
    public ResponseEntity<?> createPromoPost(@RequestBody @Valid PostPromoDTO postDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPromoPost(postDTO));
    }

    @GetMapping("/{sellerId}/countPromo")
    public ResponseEntity<?> countPromoPost(@PathVariable long sellerId) {
        return ResponseEntity.ok(postService.getNumberPromoPost(sellerId));
    }

    @GetMapping("/{sellerId}/list")
    public ResponseEntity<?> listPromoPost(@PathVariable long sellerId, @RequestParam(required = false, defaultValue = "") String order) {
        return ResponseEntity.ok(postService.getPostPromoListFromSeller(sellerId, order));
    }

    @GetMapping("/followed/{buyerId}/list")
    public ResponseEntity<?> listPostsFromTwoWeeks(@PathVariable long buyerId, @RequestParam(required = false, defaultValue = "") String order) {
        return ResponseEntity.ok(postService.getPostsPerBuyerAndFiltred(buyerId, order));
    }
}
