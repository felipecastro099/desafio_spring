package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.buyers.BuyerFollowedDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.exceptions.NotFoundException;
import com.example.praticaspringboot.repositories.BuyerRepository;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerFollowedMapper;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (buyer != null && sellerToFollow != null) {
            buyerRepository.follow(buyer, sellerToFollow);
        }

        if (buyer == null || sellerToFollow == null) {
            throw new NotFoundException("Vendedor ou comprador não encontrado.");
        }
    }

    public void unfollow(Long buyerId, Long sellerIdToUnfollow){
        Buyer buyer = buyerRepository.findById(buyerId);
        Seller sellerToFollow = sellerRepository.findById(sellerIdToUnfollow);

        if (buyer != null && sellerToFollow != null) {
            buyerRepository.unfollow(buyer, sellerToFollow);
        }

        if (buyer == null || sellerToFollow == null) {
            throw new NotFoundException("Vendedor ou comprador não encontrado.");
        }
    }

    public BuyerFollowedDTO followed(Long id) {
        Buyer buyer = buyerRepository.findById(id);

        if (buyer != null) {
            return BuyerFollowedMapper.toDto(buyer);
        }

        throw new NotFoundException("Comprador não encontrado.");
    }
}
