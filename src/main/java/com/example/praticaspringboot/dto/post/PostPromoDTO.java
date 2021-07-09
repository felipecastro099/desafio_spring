package com.example.praticaspringboot.dto.post;

import com.example.praticaspringboot.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public class PostPromoDTO {
    @NotNull(message = "userId não pode estar vazio.")
    @Positive(message = "userId é um número positivo")
    private Long userId;
    private Long id_post;
    @NotNull(message = "date não pode estar vazio.")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    @Valid
    private ProductDTO detail;
    @NotNull(message = "category não pode estar vazio.")
    @Positive(message = "price é um número positivo")
    private Long category;
    @NotNull(message = "price não pode estar vazio.")
    @Positive(message = "price é um número positivo")
    private Double price;
    @NotNull(message = "hasPromo não pode estar vazio.")
    private boolean hasPromo;
    @NotNull(message = "discount não pode estar vazio.")
    @Positive(message = "discount é um número positivo")
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
