package com.example.urlshortenerapp.repository;

import com.example.urlshortenerapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);

}
