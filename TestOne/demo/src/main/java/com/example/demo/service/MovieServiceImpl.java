package com.example.demo.service;

import com.example.demo.model.MovieData;
import com.example.demo.model.Response;
import com.example.demo.model.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService {

   private final RestTemplate restTemplate;

   private final String url = "https://jsonmock.hackerrank.com/api/movies?page=";

   public MovieServiceImpl() {
      this.restTemplate = new RestTemplate();
   }

   @Override
   public ResponseDTO getMoviesByYear(String year) {
      ResponseEntity<Response> response = restTemplate.getForEntity(url + "1", Response.class);
      Integer totalPage = response.getBody().getTotalPages();
      long count = 0L;
      for (int i = 1; i <= totalPage; i++) {
         ResponseEntity<Response> tempResponse = restTemplate.getForEntity(url + i, Response.class);
         List<MovieData> tempData = tempResponse.getBody().getData();
         count += tempData.stream()
               .filter(movie -> Objects.equals(movie.getYear(), Integer.valueOf(year)))
               .count();
      }
      ResponseDTO responseDTO = new ResponseDTO();
      responseDTO.setCount(count);
      responseDTO.setYear(year);
      return responseDTO;
   }
}
