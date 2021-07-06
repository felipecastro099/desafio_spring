package com.example.praticaspringboot.entities;

import java.util.Date;
import java.util.List;

public class Post {
    private Long id;
    private Date date;
    private List<Product> products;

    public Post(Long id, Date date, List<Product> products) {
        this.id = id;
        this.date = date;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
