package com.example.demo.controller;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/universities")
public class ThirdPartyApiController {

   UniversityService universityService;
   @Autowired
   public ThirdPartyApiController(UniversityService universityService) {
      this.universityService = universityService;
   }

   @GetMapping(value = "/")
   public ResponseEntity<List<University>> getAllUniversities() throws ExecutionException, InterruptedException {
      CompletableFuture<ResponseEntity<List<University>>> universitiesFuture = universityService.getAllUniversities();
      return universitiesFuture.get();
   }

   @GetMapping(value = "/country")
   public ResponseEntity<List<University>> getUniversitiesByCountry(@RequestParam String country) throws ExecutionException, InterruptedException{
      CompletableFuture<ResponseEntity<List<University>>> universitiesFuture = universityService.getUniversitiesByCountry(country);
      return universitiesFuture.get();
   }
}
