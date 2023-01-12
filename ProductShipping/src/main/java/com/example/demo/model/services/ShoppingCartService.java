package com.example.demo.model.services;

import com.example.demo.model.entity.CartItems;
import com.example.demo.model.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    public void saveInCart(CartItems cartItem){
        shoppingCartRepository.save(cartItem);
    }

    public List<CartItems> getAllCartItems(){
        return shoppingCartRepository.findAll();
    }
    public void deleteFromCart(int id){
        shoppingCartRepository.deleteById(id);
    }

    /*public boolean isCartItemPresent(CartItems cartItem){
        CartItems cartItem2 = shoppingCartRepository.getCartItemsById(cartItem.getId());
        return cartItem2!=null? true : false;
    }*/
}
