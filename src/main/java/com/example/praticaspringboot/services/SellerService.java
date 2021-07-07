package com.example.praticaspringboot.services;
;
import com.example.praticaspringboot.dto.sellers.SellerCountDTO;
import com.example.praticaspringboot.dto.sellers.SellerDTO;
import com.example.praticaspringboot.dto.sellers.SellerFollowersDTO;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.sellers.SellerCountMapper;
import com.example.praticaspringboot.utils.convertor.sellers.SellerFollowersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerDTO createSeller(SellerDTO sellerDTO) {
        return sellerRepository.create(sellerDTO);
    }

    public SellerCountDTO countFollow(Long id) {
        Seller seller = sellerRepository.findById(id);

        if (seller != null) {
            return SellerCountMapper.toDto(seller);
        }

        return null;
    }

    public SellerFollowersDTO followers(Long id) {
        Seller seller = sellerRepository.findById(id);

        if (seller != null) {
            return SellerFollowersMapper.toDto(seller);
        }

        return null;
    }
}
