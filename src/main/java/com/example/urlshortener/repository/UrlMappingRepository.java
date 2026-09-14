package com.example.urlshortener.repository;

import com.example.urlshortener.entity.UrlMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends CrudRepository<UrlMapping, String> {

    Optional<UrlMapping> findByOriginalUrl(String originalUrl);

    boolean existsById(String shortCode);
}