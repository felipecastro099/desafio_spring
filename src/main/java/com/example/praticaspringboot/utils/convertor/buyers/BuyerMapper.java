package com.example.praticaspringboot.utils.convertor.buyers;

import com.example.praticaspringboot.dto.buyers.BuyerDTO;
import com.example.praticaspringboot.entities.Buyer;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.generators.GenereteID;

import java.util.ArrayList;
import java.util.List;

public class BuyerMapper {
    public static BuyerDTO toDto(Buyer entitiy) {
        return new BuyerDTO(entitiy.getId(), entitiy.getName());
    }

    public static Buyer toEntity(BuyerDTO dto){
        List<Seller> followed = new ArrayList<>();
        return new Buyer(GenereteID.generateIDBuyer(), dto.getUserName(), followed);
    }
}
