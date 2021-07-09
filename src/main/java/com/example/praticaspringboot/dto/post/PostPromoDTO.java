package com.example.praticaspringboot.dto.post;

import com.example.praticaspringboot.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostPromoDTO {
    private Long userId;
    private Long id_post;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private Long category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

    public PostPromoDTO() {};

    public PostPromoDTO(Long userId, Long id_post, Date date, ProductDTO detail, Long category, Double price, boolean hasPromo, Double discount) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId_post() {
        return id_post;
    }

    public Date getDate() {
        return date;
    }

    public ProductDTO getDetail() {
        return detail;
    }

    public Long getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }
}
