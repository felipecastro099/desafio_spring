package com.example.praticaspringboot.services;

import com.example.praticaspringboot.dto.post.PostDTO;
import com.example.praticaspringboot.entities.Post;
import com.example.praticaspringboot.entities.Product;
import com.example.praticaspringboot.entities.ProductCategory;
import com.example.praticaspringboot.entities.Seller;
import com.example.praticaspringboot.exceptions.NotFoundException;
import com.example.praticaspringboot.repositories.CategoryRepository;
import com.example.praticaspringboot.repositories.PostRepository;
import com.example.praticaspringboot.repositories.ProductRepository;
import com.example.praticaspringboot.repositories.SellerRepository;
import com.example.praticaspringboot.utils.convertor.posts.PostMapper;
import com.example.praticaspringboot.utils.convertor.pruducts.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public PostDTO create (PostDTO postDTO) {
        Seller seller = sellerRepository.findById(postDTO.getUserId());
        ProductCategory category = categoryRepository.findById(postDTO.getCategory());

        if (seller == null) {
            throw new NotFoundException("Vendedor não encontrado");
        }

        if (category == null) {
            throw new NotFoundException("Categoria não encontrada");
        }

        Product product = ProductMapper.toEntity(postDTO.getDetail(), postDTO, category);

        Post post = PostMapper.toEntity(postDTO, seller, product);

        productRepository.create(product);
        postRepository.create(post);

        return PostMapper.toDto(post, category, product);
    }
}
