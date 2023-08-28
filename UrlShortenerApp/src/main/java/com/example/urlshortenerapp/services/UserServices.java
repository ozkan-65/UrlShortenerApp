package com.example.urlshortenerapp.services;

import com.example.urlshortenerapp.dto.UserDTO;
import com.example.urlshortenerapp.model.User;

import java.util.List;

public interface UserServices {
    public List<User> getAllUsers();
    public User saveOneUser(User newUser);
    public UserDTO getOneUser(Long userId);
    public User updateOneUser(Long userId, User newUser);
    public void deleteById(Long userId);
}
