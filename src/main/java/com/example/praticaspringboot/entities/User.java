package com.example.praticaspringboot.entities;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private List<User> followers;
    private List<User> followed;

    public User(Long id, String name, List<User> followers, List<User> followed) {
        this.id = id;
        this.name = name;
        this.followers = followers;
        this.followed = followed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowed() {
        return followed;
    }

    public void setFollowed(List<User> followed) {
        this.followed = followed;
    }
}
