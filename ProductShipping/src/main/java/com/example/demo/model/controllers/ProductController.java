package com.example.demo.model.controllers;

import com.example.demo.model.entity.CartItems;
import com.example.demo.model.entity.Products;
import com.example.demo.model.entity.User;
import com.example.demo.model.repositories.ShoppingCartRepository;
import com.example.demo.model.repositories.UserRepository;
import com.example.demo.model.services.ProductService;
import com.example.demo.model.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class  ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register_product")
    public String registerProduct(){
        return "register_product";
    }
    @GetMapping("/available_products")
    public ModelAndView getAllProducts(){
        List<Products> list = productService.getAllProducts();
        return new ModelAndView("available_products", "products", list);
    }
    @PostMapping("/save")
    public String addProduct(@ModelAttribute Products product){
        System.out.println("added product: " + product);
        productService.save(product);
        return "redirect:/available_products";
    }
    @GetMapping("/shopping_cart")
    public String getShopCart(Model model){
        List<CartItems> list = shoppingCartService.getAllCartItems();
        model.addAttribute("cartItems",list);
        return "shopping_cart";
    }
    @RequestMapping("/cart/{id}")
    public String getMyCart(@PathVariable("id") int id){
        Products product = productService.getProductsById(id);
        CartItems aux = shoppingCartRepository.getCartItemsByProduct(product);
        if( aux == null ){
            product.setAvailableQuantity(product.getAvailableQuantity() - 1);
            CartItems cartItem = new CartItems();
        }
        else{
            aux.setQuantity(aux.getQuantity() + 1);
            aux.setPrice(aux.getPrice() + product.getPrice());
            product.setAvailableQuantity(product.getAvailableQuantity() - 1);
        }
        return "redirect:/shopping_cart";
    }
}
