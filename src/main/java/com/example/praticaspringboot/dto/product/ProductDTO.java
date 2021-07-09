package com.example.praticaspringboot.dto.product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDTO {
    private Long product_id;
    @NotNull(message = "productName não pode estar nulo")
    @NotEmpty(message = "productName não pode estar vazio")
    private String productName;
    @NotNull(message = "type não pode estar nulo")
    @NotEmpty(message = "type não pode estar vazio")
    private String type;
    @NotNull(message = "brand não pode estar nulo")
    @NotEmpty(message = "brand não pode estar vazio")
    private String brand;
    @NotNull(message = "color não pode estar nulo")
    @NotEmpty(message = "color não pode estar vazio")
    private String color;
    @NotNull(message = "notes não pode estar nulo")
    @NotEmpty(message = "notes não pode estar vazio")
    private String notes;

    public ProductDTO(Long product_id, String productName, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }
}
