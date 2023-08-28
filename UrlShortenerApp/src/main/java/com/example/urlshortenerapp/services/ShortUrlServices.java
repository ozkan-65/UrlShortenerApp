package com.example.urlshortenerapp.services;

import com.example.urlshortenerapp.model.ShortUrl;

import java.util.List;

public interface ShortUrlServices {
    List<ShortUrl> getAllShortUrl();
    public ShortUrl getUrlByCode(String code);
    public ShortUrl create(ShortUrl shortUrl);
    public void deleteUrlId(Long urlId);
    public String generateCode();
}
