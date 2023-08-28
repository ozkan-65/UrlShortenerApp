package com.example.urlshortenerapp.controllers;

import com.example.urlshortenerapp.dto.UserDTO;
import com.example.urlshortenerapp.model.User;
import com.example.urlshortenerapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }
    @PostMapping("/signup")
    public User createUser(@RequestBody User newUser){
        return userServices.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public UserDTO getOneUser(@PathVariable Long userId ){
        return userServices.getOneUser(userId);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser ){
        return userServices.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userServices.deleteById(userId);
    }
}
