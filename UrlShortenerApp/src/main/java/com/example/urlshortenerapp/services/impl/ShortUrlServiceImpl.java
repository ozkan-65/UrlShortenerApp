package com.example.urlshortenerapp.services.impl;

import com.example.urlshortenerapp.util.RandomStringGenerator;
import com.example.urlshortenerapp.model.ShortUrl;
import com.example.urlshortenerapp.repository.ShortUrlRepository;
import com.example.urlshortenerapp.repository.UserRepository;
import com.example.urlshortenerapp.services.ShortUrlServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ShortUrlServiceImpl implements ShortUrlServices {
    private final ShortUrlRepository repository;
    private final UserRepository userRepository;
    private final RandomStringGenerator randomStringGenerator;


    @Override
    public List<ShortUrl> getAllShortUrl() {
        return repository.findAll();
    }

    @Override
    public ShortUrl getUrlByCode(String code) {
        return repository.findAllByCode(code).orElseThrow(
                ()->new RuntimeException("url not found")
        );    }

    @Override
    public ShortUrl create(ShortUrl shortUrl) {
        if (shortUrl.getCode()==null || shortUrl.getCode().isEmpty()){
            shortUrl.setCode(generateCode());
        } else if (repository.findAllByCode(shortUrl.getCode()).isPresent()) {
            throw new RuntimeException("code already exists");
        }
        shortUrl.setCode(shortUrl.getCode().toUpperCase());
        return repository.save(shortUrl);    }

    @Override
    public void deleteUrlId(Long urlId) {
        if (repository.findById(urlId).isEmpty()){
            throw new RuntimeException("There is no such url id");
        }
        repository.deleteById(urlId);

    }

    @Override
    public String generateCode() {
        String code;
        do {
            code=randomStringGenerator.generateRandomString();
        }
        while (repository.findAllByCode(code).isPresent());
        return code;    }
}
