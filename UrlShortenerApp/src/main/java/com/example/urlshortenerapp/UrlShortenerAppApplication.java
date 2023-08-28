package com.example.urlshortenerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class UrlShortenerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlShortenerAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();


    }
}
