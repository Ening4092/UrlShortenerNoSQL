package com.example.urlshortener.controller;

import com.example.urlshortener.dto.ShortenRequest;
import com.example.urlshortener.dto.ShortenResponse;
import com.example.urlshortener.entity.UrlMapping;
import com.example.urlshortener.service.UrlShortenerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {

    @Autowired
    private UrlShortenerService service;

    @PostMapping("/shorten")
    public ResponseEntity<ShortenResponse> shortenUrl(@Valid @RequestBody ShortenRequest request) {
        try {
            UrlMapping mapping = service.shortenUrl(request.getUrl());
            String shortUrl = "http://localhost:8080/" + mapping.getShortCode();

            return ResponseEntity.ok(new ShortenResponse(
                    mapping.getOriginalUrl(),
                    shortUrl,
                    mapping.getShortCode(),
                    mapping.getVisitCount(),
                    mapping.getLastVisitedAt(),
                    mapping.getCreatedAt()
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}