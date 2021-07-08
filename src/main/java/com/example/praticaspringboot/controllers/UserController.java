package com.example.praticaspringboot.controllers;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.services.BuyerService;
import com.example.praticaspringboot.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/buyer")
    public ResponseEntity<?> createBuyer(@RequestBody @Valid BuyerDTO buyerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerService.createBuyer(buyerDTO));
    }

    @PostMapping("/seller")
    public ResponseEntity<?> createSeller(@RequestBody SellerDTO sellerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.createSeller(sellerDTO));
    }

    @PostMapping("/{buyerId}/follow/{sellerIdToFollow}")
    public ResponseEntity<?> follow(@PathVariable Long buyerId, @PathVariable Long sellerIdToFollow) {
        buyerService.follow(buyerId, sellerIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{buyerId}/unfollow/{sellerIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable Long buyerId, @PathVariable Long sellerIdToUnfollow) {
        buyerService.unfollow(buyerId, sellerIdToUnfollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{sellerId}/followers/count/")
    public ResponseEntity<?> count(@PathVariable Long sellerId) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.countFollow(sellerId));
    }

    @GetMapping("/{sellerId}/followers/list")
    public ResponseEntity<?> followers(@PathVariable Long sellerId) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.followers(sellerId));
    }

    @GetMapping("/{buyerId}/followed/list")
    public ResponseEntity<?> followed(@PathVariable Long buyerId) {
        return ResponseEntity.status(HttpStatus.OK).body(buyerService.followed(buyerId));
    }
}
