package com.example.urlshortenerapp.request;

import com.example.urlshortenerapp.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShortUrlRequest {

    @NotNull
    @NotEmpty
    private String url;

    private String code;
    private Long userId;
}
