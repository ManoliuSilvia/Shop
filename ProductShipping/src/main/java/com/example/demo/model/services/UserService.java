package com.example.demo.model.services;
import com.example.demo.model.entity.User;
import com.example.demo.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(String firstName, String lastName,String email, String password, String address){
        if(firstName == null || lastName == null || email == null || password == null || address == null )
            return null;
        else{
            User newUser = new User();
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setAddress(address);
            return userRepository.save(newUser);
        }
    }
    public User loginUser(String email, String password){
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }
}
