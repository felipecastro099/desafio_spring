package com.example.praticaspringboot.dto.post;

import com.example.praticaspringboot.dto.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostDTO {
    private Long userId;
    private Long id_post;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date date;
    private ProductDTO detail;
    private Long category;
    private Double price;

    public PostDTO() {}

    public PostDTO(Long userId, Long id_post, Date date, ProductDTO detail, Long category, Double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
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
}
