package com.example.praticaspringboot.utils.convertor.sellers;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.dto.sellers.SellerFollowersDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.convertor.buyers.BuyerMapper;

import java.util.ArrayList;
import java.util.List;

public class SellerFollowersMapper {
    public static SellerFollowersDTO toDto(Seller entitiy) {
        return new SellerFollowersDTO(entitiy.getId(), entitiy.getName(), buyerDTOList(entitiy.getFollowers()));
    }

    public static List<BuyerDTO> buyerDTOList(List<Buyer> buyers) {
        List<BuyerDTO> list = new ArrayList<>();

        buyers.stream().forEach(buyer -> list.add(BuyerMapper.toDto(buyer)));

        return list;
    }
}
