package com.example.urlshortener.dto;

import java.time.LocalDateTime;

public class ShortenResponse {
    private String originalUrl;
    private String shortUrl;
    private String shortCode;
    private Long visitCount;
    private LocalDateTime lastVisitedAt;
    private LocalDateTime createdAt;

    public ShortenResponse(String originalUrl, String shortUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.shortCode = shortCode;
    }

    public ShortenResponse() {
    }

    public ShortenResponse(String originalUrl, String shortUrl, String shortCode,
                           Long visitCount, LocalDateTime lastVisitedAt, LocalDateTime createdAt) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.shortCode = shortCode;
        this.visitCount = visitCount;
        this.lastVisitedAt = lastVisitedAt;
        this.createdAt = createdAt;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDateTime getLastVisitedAt() {
        return lastVisitedAt;
    }

    public void setLastVisitedAt(LocalDateTime lastVisitedAt) {
        this.lastVisitedAt = lastVisitedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
