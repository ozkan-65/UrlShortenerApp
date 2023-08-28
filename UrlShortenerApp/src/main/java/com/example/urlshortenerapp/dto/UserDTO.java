package com.example.urlshortenerapp.dto;

import com.example.urlshortenerapp.model.ShortUrl;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserDTO{


        private Long id;
        private String userName;
        List<ShortUrl> shortUrls;


}
