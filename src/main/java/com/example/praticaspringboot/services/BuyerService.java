package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.buyers.BuyerFollowedDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.repositories.BuyerRepository;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerFollowedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public BuyerDTO createBuyer(BuyerDTO buyerDTO) {
        return buyerRepository.create(buyerDTO);
    }

    public void follow(Long buyerId, Long sellerIdToFollow) {
        Buyer buyer = buyerRepository.findById(buyerId);
        Seller sellerToFollow = sellerRepository.findById(sellerIdToFollow);

        if (buyer != null && sellerToFollow != null) {
            buyerRepository.follow(buyer, sellerToFollow);
        }
    }

    public BuyerFollowedDTO followed(Long id) {
        Buyer buyer = buyerRepository.findById(id);

        if (buyer != null) {
            return BuyerFollowedMapper.toDto(buyer);
        }

        return null;
    }
}
