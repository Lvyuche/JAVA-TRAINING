package com.example.demo.service;

import com.example.demo.model.University;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UniversityService {
   ResponseEntity<List<University>> getUniversitiesByCountry(String country);

   ResponseEntity<List<University>> getAllUniversities();
}
