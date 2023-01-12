package com.example.demo.model.controllers;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repositories.UserRepository;
import com.example.demo.model.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class  ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register_product")
    public String registerProduct(){
        return "register_product";
    }
    @GetMapping("/available_products")
    public ModelAndView getAllProducts(){
        List<Product> list = productService.getAllProducts();
        return new ModelAndView("available_products", "products", list);
    }
    @PostMapping("/save")
    public String addProduct(@ModelAttribute Product product){
        System.out.println("added product: " + product);
        productService.save(product);
        return "redirect:/available_products";
    }
}
