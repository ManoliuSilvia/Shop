package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @SequenceGenerator(
            name = "products_sequence",
            sequenceName = "products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"
    )
    private Integer product_id;
    private String name;
    private String retailer;
    private Integer price;
    private Integer availableQuantity;

    public Products(Integer product_id, String name, String retailer, Integer price, Integer availableQuantity) {
        this.product_id = product_id;
        this.name = name;
        this.retailer = retailer;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }
    public Products() {
        super();
    }
    public Integer getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRetailer() {
        return retailer;
    }
    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getAvailableQuantity() {
        return availableQuantity;
    }
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
