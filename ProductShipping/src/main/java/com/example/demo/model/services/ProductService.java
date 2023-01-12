package com.example.demo.model.services;

import com.example.demo.model.entity.Products;
import com.example.demo.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void save(Products product){
        productRepository.save(product);
    }
    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
    public Products getProductsById(int id){
        return productRepository.findById(id).get();
    }
}
