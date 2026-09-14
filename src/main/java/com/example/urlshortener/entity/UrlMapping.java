package com.example.urlshortener.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@RedisHash("UrlMapping")
public class UrlMapping implements Serializable {

    @Id
    private String shortCode;

    @Indexed
    private String originalUrl;

    private LocalDateTime createdAt;
    private Long visitCount = 0L;
    private LocalDateTime lastVisitedAt;

    @TimeToLive(unit = TimeUnit.SECONDS)
    private Long timeToLive = 2592000L;

    public UrlMapping() {
        this.createdAt = LocalDateTime.now();
    }

    public UrlMapping(String shortCode, String originalUrl) {
        this();
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
    }

    public UrlMapping(String shortCode, String originalUrl, Long timeToLiveSeconds) {
        this(shortCode, originalUrl);
        this.timeToLive = timeToLiveSeconds;
    }


    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public Long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long timeToLive) {
        this.timeToLive = timeToLive;
    }
}