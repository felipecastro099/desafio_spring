package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BuyerRepository {

    List<Buyer> buyers = new ArrayList<>();

    public BuyerDTO create(BuyerDTO buyerDTO) {
        Buyer buyer = BuyerMapper.toEntity(buyerDTO);

        buyers.add(buyer);

        return BuyerMapper.toDto(buyer);
    }

    public Buyer findById(Long id) {
        Optional<Buyer> buyerOptional = buyers.stream().filter(v -> v.getId() == id).findFirst();

        return buyerOptional.orElse(null);
    }

    public void follow(Buyer buyer, Seller sellerToFollow) {
        buyer.getFollowed().add(sellerToFollow);
        sellerToFollow.getFollowers().add(buyer);
    }
}
