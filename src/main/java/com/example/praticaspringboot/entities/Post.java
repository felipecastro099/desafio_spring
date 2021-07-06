package com.example.praticaspringboot.entities;

import java.util.Date;

public class Post {
    private Long id;
    private Date date;
    private User user;
    private Product product;

    public Post(Long id, Date date, User user, Product product) {
        this.id = id;
        this.date = date;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
