package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.buyers.BuyerFollowedDTO;
import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.exceptions.NotFoundException;
import com.example.praticaspringboot.repositories.BuyerRepository;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerFollowedMapper;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public BuyerDTO createBuyer(BuyerDTO buyerDTO) {
        Buyer buyer = BuyerMapper.toEntity(buyerDTO);

        Buyer result = buyerRepository.create(buyer);

        return BuyerMapper.toDto(result);
    }

    public void follow(Long buyerId, Long sellerIdToFollow){
        Buyer buyer = buyerRepository.findById(buyerId);
        Seller sellerToFollow = sellerRepository.findById(sellerIdToFollow);

        buyerRepository.follow(buyer, sellerToFollow);

    }

    public void unfollow(Long buyerId, Long sellerIdToUnfollow){
        Buyer buyer = buyerRepository.findById(buyerId);
        Seller sellerToFollow = sellerRepository.findById(sellerIdToUnfollow);

        buyerRepository.unfollow(buyer, sellerToFollow);
    }

    public BuyerFollowedDTO followed(Long id, String order) {
        Buyer buyer = buyerRepository.findById(id);
        BuyerFollowedDTO buyerFollowedDTO = BuyerFollowedMapper.toDto(buyer);

        if(order.equals("name_asc")) {
            Collections.sort(buyerFollowedDTO.getFollowed(), Comparator.comparing(SellerDTO::getUserName));
        }

        if(order.equals("name_desc")) {
            Collections.sort(buyerFollowedDTO.getFollowed(), Comparator.comparing(SellerDTO::getUserName).reversed());
        }

        return buyerFollowedDTO;
    }


}
