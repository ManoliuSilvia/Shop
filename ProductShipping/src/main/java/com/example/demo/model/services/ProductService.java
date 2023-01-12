package com.example.demo.model.services;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void save(Product product){
        productRepository.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductsById(int id){
        return productRepository.findById(id).get();
    }
}
