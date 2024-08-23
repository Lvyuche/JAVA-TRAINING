package com.example.demo.controller;

import com.example.demo.model.ResponseDTO;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {

   MovieService movieService;

   @Autowired
   public MovieController(MovieService movieService) {
      this.movieService = movieService;
   }

   @GetMapping("/movies")
   public ResponseEntity<ResponseDTO> getMoviesByYear(@RequestParam String year){
      ResponseDTO responseDTO = movieService.getMoviesByYear(year);
      return new ResponseEntity<>(responseDTO, HttpStatus.OK);
   }
}
