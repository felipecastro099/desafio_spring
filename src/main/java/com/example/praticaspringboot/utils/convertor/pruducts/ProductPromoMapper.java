package com.example.praticaspringboot.utils.convertor.pruducts;

import com.example.praticaspringboot.dto.post.PostDTO;
import com.example.praticaspringboot.dto.post.PostPromoDTO;
import com.example.praticaspringboot.dto.product.ProductDTO;
import com.example.praticaspringboot.entities.Product;
import com.example.praticaspringboot.entities.ProductCategory;
import com.example.praticaspringboot.utils.generators.GenereteID;

public class ProductPromoMapper {
    public static ProductDTO toDto(Product entitie) {
        return new ProductDTO(entitie.getId(), entitie.getName(), entitie.getType(), entitie.getBrand(), entitie.getColor(), entitie.getNotes());
    }

    public static Product toEntity(ProductDTO productDTO, PostPromoDTO postDTO, ProductCategory category) {
        return new Product(GenereteID.generateIDProduct(), productDTO.getProductName(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes(), postDTO.getPrice(),category, postDTO.isHasPromo(), postDTO.getDiscount());
    }
}
