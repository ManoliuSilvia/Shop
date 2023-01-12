package com.example.demo.model.DTO;

import com.example.demo.model.entity.Product;

import java.util.List;

public class ProductDTO {
    public Integer id;
    public Integer quantity;

    public ProductDTO() {
    }

    public ProductDTO(Integer productId, Integer quantity) {
        this.id = productId;
        this.quantity = quantity;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
