package com.example.praticaspringboot.entities;

import java.util.List;

public class Seller extends User {

    private List<Buyer> followers;

    public Seller(Long id, String name, List<Buyer> followers) {
        super(id, name);
        this.followers = followers;
    }

    public List<Buyer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Buyer> followers) {
        this.followers = followers;
    }
}
