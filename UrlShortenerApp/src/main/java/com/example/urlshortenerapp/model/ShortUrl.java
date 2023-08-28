package com.example.urlshortenerapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shurl")
@Getter
@Setter
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId", nullable = false)
    @JsonIgnore
    private User user;

    private String url;

    @Column(unique = true)
    private String code;


}
