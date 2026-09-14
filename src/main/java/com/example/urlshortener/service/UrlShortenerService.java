package com.example.urlshortener.service;

import com.example.urlshortener.entity.UrlMapping;
import com.example.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository repository;

    @Value("${url.ttl.days:30}")
    private long ttlDays;

    private static final int SHORT_CODE_LENGTH = 7;
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public UrlMapping shortenUrl(String originalUrl) {
        if (!isValidUrl(originalUrl)) {
            throw new IllegalArgumentException("Invalid URL format");
        }

        Optional<UrlMapping> existingMapping = repository.findByOriginalUrl(originalUrl);
        if (existingMapping.isPresent()) {
            return existingMapping.get();
        }

        String shortCode = generateUniqueShortCode();
        long ttlSeconds = ttlDays * 24 * 60 * 60;

        UrlMapping mapping = new UrlMapping(shortCode, originalUrl, ttlSeconds);
        return repository.save(mapping);
    }

    public String getOriginalUrl(String shortCode) {
        UrlMapping mapping = repository.findById(shortCode)
                .orElseThrow(() -> new NoSuchElementException("Short URL not found: " + shortCode));

        mapping.setVisitCount(mapping.getVisitCount() + 1);
        mapping.setLastVisitedAt(LocalDateTime.now());

        mapping.setTimeToLive(ttlDays * 24 * 60 * 60);

        repository.save(mapping);

        return mapping.getOriginalUrl();
    }

    private String generateUniqueShortCode() {
        StringBuilder shortCode = new StringBuilder();
        Random random = new Random();

        do {
            shortCode.setLength(0);
            for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
                shortCode.append(CHARS.charAt(random.nextInt(CHARS.length())));
            }
        } while (repository.existsById(shortCode.toString()));

        return shortCode.toString();
    }

    private boolean isValidUrl(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}