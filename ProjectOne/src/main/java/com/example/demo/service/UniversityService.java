package com.example.demo.service;

import com.example.demo.model.University;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UniversityService {
   CompletableFuture<ResponseEntity<List<University>>> getUniversitiesByCountry(String country);

   CompletableFuture<ResponseEntity<List<University>>> getAllUniversities();
}
