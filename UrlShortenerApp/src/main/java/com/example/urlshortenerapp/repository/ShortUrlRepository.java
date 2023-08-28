package com.example.urlshortenerapp.repository;

import com.example.urlshortenerapp.model.ShortUrl;
import com.example.urlshortenerapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl,Long> {
    Optional<ShortUrl> findAllByCode(String code);
    List<ShortUrl> findByUser(User user);

}
