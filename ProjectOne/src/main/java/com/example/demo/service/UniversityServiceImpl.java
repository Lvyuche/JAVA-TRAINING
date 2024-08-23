package com.example.demo.service;

import com.example.demo.model.University;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UniversityServiceImpl implements UniversityService{

   @Override
   @Async
   public CompletableFuture<ResponseEntity<List<University>>> getUniversitiesByCountry(String country) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "http://universities.hipolabs.com/search?country=" + country;
      ResponseEntity<List<University>> response = restTemplate.exchange(
            url,
            org.springframework.http.HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<University>>() {}
      );
      return CompletableFuture.completedFuture(new ResponseEntity<>(response.getBody(), HttpStatus.OK));
   }

   @Override
   @Async
   public CompletableFuture<ResponseEntity<List<University>>> getAllUniversities() {
      RestTemplate restTemplate = new RestTemplate();
      String url = "http://universities.hipolabs.com/search";
      ResponseEntity<List<University>> response = restTemplate.exchange(
            url,
            org.springframework.http.HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<University>>() {}
      );
      return CompletableFuture.completedFuture(new ResponseEntity<>(response.getBody(), HttpStatus.OK));
   }
}
