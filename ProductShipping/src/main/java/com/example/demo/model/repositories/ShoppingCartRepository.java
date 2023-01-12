package com.example.demo.model.repositories;

import com.example.demo.model.entity.CartItems;
import com.example.demo.model.entity.Products;
import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<CartItems,Integer> {
    public CartItems getCartItemsByProduct(Products product);
    public List<CartItems> getCartItemsByUser(User user);
}
