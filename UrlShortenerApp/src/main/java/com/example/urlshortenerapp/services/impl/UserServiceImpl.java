package com.example.urlshortenerapp.services.impl;

import com.example.urlshortenerapp.dto.UserDTO;
import com.example.urlshortenerapp.model.ShortUrl;
import com.example.urlshortenerapp.model.User;
import com.example.urlshortenerapp.repository.ShortUrlRepository;
import com.example.urlshortenerapp.repository.UserRepository;
import com.example.urlshortenerapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
   private final UserRepository userRepository;
   private final ShortUrlRepository shortUrlRepository;
   private final ModelMapper modelMapper;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();    }

    @Override
    public User saveOneUser(User newUser) {
        if (userRepository.findByUserName(newUser.getUserName())!=null){
            throw new IllegalArgumentException("This username is already in use: "+ newUser.getUserName());
        }
        return userRepository.save(newUser);    }

    @Override
    public UserDTO getOneUser(Long userId) {
        if (userRepository.findById(userId).isEmpty()){
            throw new RuntimeException("There is no such user id");
        }
        UserDTO userDTO = new UserDTO();
        Optional<User> user = userRepository.findById(userId);
        userDTO = modelMapper.map(user.get(), UserDTO.class);
        List<ShortUrl> shortUrls = shortUrlRepository.findByUser(user.get());
        userDTO.setShortUrls(shortUrls);
        return userDTO;
    }

    @Override
    public User updateOneUser(Long userId, User newUser) {
        if (userRepository.findById(userId).isEmpty()){
            throw new RuntimeException("There is no such user id");
        }
        Optional<User> user=userRepository.findById(userId);
        if (user.isPresent()){
            User foundUser=user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
        else {
            return null;
        }    }

    @Override
    public void deleteById(Long userId) {
        if (userRepository.findById(userId).isEmpty()){
            throw new RuntimeException("There is no such user id");
        }
        userRepository.deleteById(userId);

    }
}
