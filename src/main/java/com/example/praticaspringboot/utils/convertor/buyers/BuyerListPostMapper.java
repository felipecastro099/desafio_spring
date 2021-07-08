package com.example.praticaspringboot.utils.convertor.buyers;

import com.example.praticaspringboot.dto.buyers.BuyerListPostDTO;
import com.example.praticaspringboot.dto.post.PostListDTO;
import com.example.praticaspringboot.entities.Buyer;

import java.util.List;

public class BuyerListPostMapper {
    public static BuyerListPostDTO toDto(Buyer buyer, List<PostListDTO> posts) {
        return new BuyerListPostDTO(buyer.getId(), posts);
    }
}
