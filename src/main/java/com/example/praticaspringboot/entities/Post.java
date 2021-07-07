package com.example.praticaspringboot.entities;

import java.util.Date;

public class Post {
    private Long id;
    private Date date;
    private Seller seller;
    private Product product;

    public Post(Long id, Date date, Seller seller, Product product) {
        this.id = id;
        this.date = date;
        this.seller = seller;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
