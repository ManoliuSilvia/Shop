package com.example.demo.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/myOrders")
    public String myOrders(){
        return "my_orders";
    }
}
