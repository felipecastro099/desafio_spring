package com.example.praticaspringboot.services;
;
import com.example.praticaspringboot.dto.sellers.SellerCountDTO;
import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.dto.sellers.SellerFollowersDTO;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.exceptions.NotFoundException;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.sellers.SellerCountMapper;
import com.example.praticaspringboot.utils.convertor.sellers.SellerFollowersMapper;
import com.example.praticaspringboot.utils.convertor.sellers.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerDTO createSeller(SellerDTO sellerDTO) {
        Seller seller = SellerMapper.toEntity(sellerDTO);
        Seller result = sellerRepository.create(seller);

        return SellerMapper.toDto(result);
    }

    public SellerCountDTO countFollow(Long id) {
        Seller seller = sellerRepository.findById(id);

        if (seller != null) {
            return SellerCountMapper.toDto(seller);
        }

        throw new NotFoundException("Seller not found.");
    }

    public SellerFollowersDTO followers(Long id) {
        Seller seller = sellerRepository.findById(id);

        if (seller != null) {
            return SellerFollowersMapper.toDto(seller);
        }

        throw new NotFoundException("Seller not found.");
    }
}
