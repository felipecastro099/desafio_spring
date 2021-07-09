package com.example.praticaspringboot.repositories;

import com.example.praticaspringboot.entities.Product;
import com.example.praticaspringboot.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    public List<Product> products = new ArrayList<>();

    public Product create(Product product) {
        products.add(product);

        return product;
    }

    public Product findById(Long id) {
        Optional<Product> result = products.stream().filter(product -> product.getId() == id).findFirst();

        if (result.isPresent()) {
            return result.get();
        }

        throw new NotFoundException("Produto não encontrado.");
    }
}
