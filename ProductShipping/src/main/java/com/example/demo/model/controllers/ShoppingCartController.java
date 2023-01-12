package com.example.demo.model.controllers;

import com.example.demo.model.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @RequestMapping("/deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable("id") int id){
        return "redirect:/shopping_cart ";
    }
}
