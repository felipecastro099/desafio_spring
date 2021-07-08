package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.sellers.SellerCountDTO;
import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.dto.sellers.SellerFollowersDTO;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.repositories.BuyerRepository;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.sellers.SellerCountMapper;
import com.example.praticaspringboot.utils.convertor.sellers.SellerFollowersMapper;
import com.example.praticaspringboot.utils.convertor.sellers.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    public SellerDTO createSeller(SellerDTO sellerDTO) {
        Seller seller = SellerMapper.toEntity(sellerDTO);
        Seller result = sellerRepository.create(seller);

        return SellerMapper.toDto(result);
    }

    public SellerCountDTO countFollow(Long id) {
        Seller seller = sellerRepository.findById(id);

        return SellerCountMapper.toDto(seller);
    }

    public SellerFollowersDTO followers(Long id, String order) {
        Seller seller = sellerRepository.findById(id);
        SellerFollowersDTO sellerFollowersDTO = SellerFollowersMapper.toDto(seller);

        if(order.equals("name_asc")) {
            Collections.sort(sellerFollowersDTO.getFollowers(), Comparator.comparing(BuyerDTO::getUserName));
        }

        if(order.equals("name_desc")) {
            Collections.sort(sellerFollowersDTO.getFollowers(), Comparator.comparing(BuyerDTO::getUserName).reversed());
        }

        return sellerFollowersDTO;
    }
}
