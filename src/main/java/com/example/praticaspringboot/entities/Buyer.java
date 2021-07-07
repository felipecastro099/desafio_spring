package com.example.praticaspringboot.entities;

import java.util.List;

public class Buyer extends User {
    private List<Seller> followed;

    public Buyer(Long id, String name, List<Seller> followed) {
        super(id, name);
        this.followed = followed;
    }

    public List<Seller> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Seller> followed) {
        this.followed = followed;
    }
}
