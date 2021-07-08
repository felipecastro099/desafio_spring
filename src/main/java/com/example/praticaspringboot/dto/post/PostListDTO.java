package com.example.praticaspringboot.dto.post;

import com.example.praticaspringboot.dto.product.ProductDTO;

import java.util.Date;

public class PostListDTO {
    private Long id_post;
    private Date date;
    private ProductDTO detail;
    private Long category;
    private Double price;

    public PostListDTO(Long id_post, Date date, ProductDTO detail, Long category, Double price) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
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
}
