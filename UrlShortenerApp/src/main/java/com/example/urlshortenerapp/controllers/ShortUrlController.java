package com.example.urlshortenerapp.controllers;

import com.example.urlshortenerapp.dto.ShortUrlDTO;
import com.example.urlshortenerapp.dto.converter.ShortUrlDTOConvertor;
import com.example.urlshortenerapp.model.ShortUrl;
import com.example.urlshortenerapp.request.ShortUrlRequest;
import com.example.urlshortenerapp.request.converter.ShortUrlRequestConverter;
import com.example.urlshortenerapp.services.ShortUrlServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ShortUrlController {
    private final ShortUrlDTOConvertor shortUrlDtoConvertor;
    private final ShortUrlRequestConverter shortUrlRequestConverter;
    private final ShortUrlServices shortUrlService;

    @GetMapping("/allUrls")
    public ResponseEntity<List<ShortUrlDTO>> getAllUrls(){
        return new ResponseEntity<List<ShortUrlDTO>>(
                shortUrlDtoConvertor.convertToDto(shortUrlService.getAllShortUrl()), HttpStatus.OK
        );
    }
    @GetMapping("/show/{code}")
    public ResponseEntity<?> getUrlByCode(@Valid @NotEmpty @PathVariable String code){
        return new ResponseEntity<ShortUrlDTO>(
                shortUrlDtoConvertor.convertToDto(shortUrlService.getUrlByCode(code)),HttpStatus.OK
        );
    }
   @GetMapping("{code}")
    public ResponseEntity<?> redirect( @PathVariable String code) throws URISyntaxException {
        ShortUrl shortUrl=shortUrlService.getUrlByCode(code);
        URI uri= new URI(shortUrl.getUrl());
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(
                httpHeaders,HttpStatus.SEE_OTHER
        );

    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ShortUrlRequest shortUrlRequest){
        ShortUrl shortUrl=shortUrlRequestConverter.convertToEntity(shortUrlRequest);
        return new ResponseEntity<ShortUrlDTO>(shortUrlDtoConvertor.convertToDto(shortUrlService.create(shortUrl)),HttpStatus.CREATED);
    }
    @DeleteMapping("/{urlId}")
    public void deleteUrl(@PathVariable Long urlId){
        shortUrlService.deleteUrlId(urlId);

    }

}
