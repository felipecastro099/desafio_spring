package com.example.praticaspringboot.utils.convertor.sellers;

import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.generators.GenereteID;

import java.util.ArrayList;
import java.util.List;

public class SellerMapper {
    public static SellerDTO toDto(Seller entitiy) {
        return new SellerDTO(entitiy.getId(), entitiy.getName());
    }

    public static Seller toEntity(SellerDTO dto){
        List<Buyer> followers = new ArrayList<>();
        return new Seller(GenereteID.generateIDSeller(), dto.getUserName(), followers);
    }
}
