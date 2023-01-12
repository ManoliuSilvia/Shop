package com.example.demo.model.controllers;

import com.example.demo.model.DTO.ProductDTO;
import com.example.demo.model.entity.Product;
import com.example.demo.model.repositories.UserRepository;
import com.example.demo.model.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class  ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    private UserRepository userRepository;
    private List<ProductDTO> selectedItems = new ArrayList<>();
    @GetMapping("/register_product")
    public String registerProduct(){
        return "register_product";
    }
    @GetMapping("/available_products")
    public ModelAndView getAllProducts(){
        List<Product> list = productService.getAllProducts();
        ModelAndView modelAndView =  new ModelAndView("available_products", "products", list);
        modelAndView.getModelMap().addAttribute("selectedProduct",new ProductDTO());
        return modelAndView;
    }
    @PostMapping("/save")
    public String addProduct(@ModelAttribute Product product){
        System.out.println("added product: " + product);
        productService.save(product);
        return "redirect:/available_products";
    }
    @PostMapping("/cart")
    public String addOne(@ModelAttribute ProductDTO selectedProduct){
        //Product product = productService.getProductsById(id);
        ProductDTO productDTO = new ProductDTO();
        selectedItems.add(selectedProduct);
        return "available_products";
    }
}
