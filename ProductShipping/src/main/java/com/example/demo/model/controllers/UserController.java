package com.example.demo.model.controllers;

import com.example.demo.model.entity.User;
import com.example.demo.model.repositories.UserRepository;
import com.example.demo.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request " + user);
        User registerNewUser = userService.registerUser(user.getFirstName(), user.getLastName(),
                user.getEmail(),user.getPassword(), user.getAddress());
        return registerNewUser == null ? "error_page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login request " + user);
        User loginNewUser = userService.loginUser(user.getEmail(),user.getPassword());
        if(loginNewUser != null ){
            model.addAttribute("userLogin",loginNewUser.getFirstName());
            model.addAttribute("userId",loginNewUser.getId());
            return "personal_page";
        }
        else {
            return "error_page";
        }
    }
    @PostMapping("/shopping_cart")
    public String ShoppingC(@RequestParam (name="userID") int userID){
        return "";
    }
}
