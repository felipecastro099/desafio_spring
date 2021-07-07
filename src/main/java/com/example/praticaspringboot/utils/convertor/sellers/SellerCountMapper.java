package com.example.praticaspringboot.utils.convertor.sellers;

import com.example.praticaspringboot.dto.sellers.SellerCountDTO;
import com.example.praticaspringboot.entities.Seller;

public class SellerCountMapper {
    public static SellerCountDTO toDto(Seller entitiy) {
        return new SellerCountDTO(entitiy.getId(), entitiy.getName(), entitiy.getFollowers().size());
    }
}
