package com.example.urlshortenerapp.dto.converter;

import com.example.urlshortenerapp.dto.ShortUrlDTO;
import com.example.urlshortenerapp.model.ShortUrl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShortUrlDTOConvertor {
    public ShortUrlDTO convertToDto(ShortUrl shortUrl){
        return ShortUrlDTO.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .code(shortUrl.getCode())
                .userId(shortUrl.getUser().getId())
                .build();
    }
    public  List<ShortUrlDTO> convertToDto(List<ShortUrl> shortUrl){
        return shortUrl.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
