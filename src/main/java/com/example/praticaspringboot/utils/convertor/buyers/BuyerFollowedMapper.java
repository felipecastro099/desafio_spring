package com.example.praticaspringboot.utils.convertor.buyers;

import com.example.praticaspringboot.dto.buyers.BuyerFollowedDTO;
import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.convertor.sellers.SellerMapper;

import java.util.ArrayList;
import java.util.List;

public class BuyerFollowedMapper {
    public static BuyerFollowedDTO toDto(Buyer entitiy) {
        return new BuyerFollowedDTO(entitiy.getId(), entitiy.getName(), buyerDTOList(entitiy.getFollowed()));
    }

    public static List<SellerDTO> buyerDTOList(List<Seller> sellers) {
        List<SellerDTO> list = new ArrayList<>();

        sellers.stream().forEach(seller -> list.add(SellerMapper.toDto(seller)));

        return list;
    }
}
