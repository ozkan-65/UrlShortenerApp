package com.example.urlshortenerapp.dto;

import lombok.*;

@Builder
@Getter
@Setter
public class ShortUrlDTO {
    private Long id;
    private String url;
    private String code;
    private Long userId;
}
