package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    public List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        posts.add(post);

        return post;
    }

    public Post findById(Long id) {
        Optional<Post> result = posts.stream().filter(post -> post.getId() == id).findFirst();

        return result.orElse(null);
    }
}
