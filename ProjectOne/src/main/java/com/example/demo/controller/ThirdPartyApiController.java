package com.example.demo.controller;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class ThirdPartyApiController {

   UniversityService universityService;
   @Autowired
   public ThirdPartyApiController(UniversityService universityService) {
      this.universityService = universityService;
   }

   @GetMapping(value = "/")
   public ResponseEntity<List<University>> getAllUniversities(){
      ResponseEntity<List<University>> universities = universityService.getAllUniversities();
      return new ResponseEntity<>(universities.getBody(), HttpStatus.OK);
   }

   @GetMapping(value = "/country")
   public ResponseEntity<List<University>> getUniversitiesByCountry(@RequestParam String country){
      ResponseEntity<List<University>> universities = universityService.getUniversitiesByCountry(country);
      return new ResponseEntity<>(universities.getBody(), HttpStatus.OK);
   }
}
