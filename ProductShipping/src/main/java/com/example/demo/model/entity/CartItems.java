package com.example.demo.model.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "Shopping Cart")
public class CartItems {
    @Id
    @SequenceGenerator(
            name = "sc_sequence",
            sequenceName = "sc_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sc_sequence"
    )
    private Integer id;
    private String name;
    private Integer price;
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Products product;

    public Products getProduct() {
        return product;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public CartItems(String name, Integer price, Integer quantity, Products product) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setProduct(Products product) {
        this.product = product;
    }

    public CartItems() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
