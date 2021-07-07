package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.utils.convertor.sellers.SellerMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepository {
    List<Seller> sellers = new ArrayList<>();

    public SellerDTO create(SellerDTO sellerDTO) {
        Seller seller = SellerMapper.toEntity(sellerDTO);

        sellers.add(seller);

        return SellerMapper.toDto(seller);
    }

    public Seller findById(Long id) {
        Optional<Seller> sellerOptional = sellers.stream().filter(v -> v.getId() == id).findFirst();

        return sellerOptional.orElse(null);
    }
}
