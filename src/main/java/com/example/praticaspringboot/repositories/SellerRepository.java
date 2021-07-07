package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.entities.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepository {
    List<Seller> sellers = new ArrayList<>();

    public Seller create(Seller seller) {
        sellers.add(seller);

        return seller;
    }

    public Seller findById(Long id) {
        Optional<Seller> sellerOptional = sellers.stream().filter(v -> v.getId() == id).findFirst();

        return sellerOptional.orElse(null);
    }
}
