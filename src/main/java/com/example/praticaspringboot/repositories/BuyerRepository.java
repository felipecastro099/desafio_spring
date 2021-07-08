package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BuyerRepository {

    List<Buyer> buyers = new ArrayList<>();

    public Buyer create(Buyer buyer) {
        buyers.add(buyer);

        return buyer;
    }

    public Buyer findById(Long id) {
        Optional<Buyer> buyerOptional = buyers.stream().filter(v -> v.getId() == id).findFirst();

        if (buyerOptional.isPresent()){
            return buyerOptional.get();
        }

        throw new NotFoundException("Comprador não encontrado");
    }

    public void follow(Buyer buyer, Seller sellerToFollow) {
        buyer.getFollowed().add(sellerToFollow);
        sellerToFollow.getFollowers().add(buyer);
    }

    public void unfollow(Buyer buyer, Seller sellerToUnfollow) {
        buyer.getFollowed().remove(sellerToUnfollow);
        sellerToUnfollow.getFollowers().remove(buyer);
    }
}
