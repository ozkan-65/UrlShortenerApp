package com.example.urlshortenerapp.request.converter;

import com.example.urlshortenerapp.dto.UserDTO;
import com.example.urlshortenerapp.model.ShortUrl;
import com.example.urlshortenerapp.model.User;
import com.example.urlshortenerapp.request.ShortUrlRequest;
import com.example.urlshortenerapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShortUrlRequestConverter {
    private final UserServices userServices;
    private final ModelMapper modelMapper;
    public ShortUrl convertToEntity(ShortUrlRequest shortUrlRequest){
       UserDTO userDTO= userServices.getOneUser(shortUrlRequest.getUserId());
       User user=modelMapper.map(userDTO,User.class);
        return ShortUrl.builder()
                .url(shortUrlRequest.getUrl())
                .code(shortUrlRequest.getCode())
                .user(user)
                .build();
    }
}
