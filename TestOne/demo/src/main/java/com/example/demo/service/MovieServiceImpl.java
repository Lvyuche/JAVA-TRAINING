package com.example.demo.service;

import com.example.demo.model.MovieData;
import com.example.demo.model.Response;
import com.example.demo.model.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

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

      ExecutorService executorService = Executors.newCachedThreadPool();
      List<Future<Long>> futures = new ArrayList<>();

      for (int i = 1; i <= totalPage; i++) {
         int page = i;
         Callable<Long> task = () -> getCountByPage(page, year);
         Future<Long> future = executorService.submit(task);
         futures.add(future);
      }

      long count = futures.stream()
            .mapToLong(future -> {
               try {
                  return future.get();
               } catch (InterruptedException | ExecutionException e) {
                  e.printStackTrace();
                  return 0L;
               }
            })
            .sum();

      executorService.shutdown();

      ResponseDTO responseDTO = new ResponseDTO();
      responseDTO.setCount(count);
      responseDTO.setYear(year);
      return responseDTO;
   }

   public Long getCountByPage(int page, String year) {
      ResponseEntity<Response> tempResponse = restTemplate.getForEntity(url + page, Response.class);
      List<MovieData> tempData = tempResponse.getBody().getData();
      return tempData.stream()
            .filter(movie -> Objects.equals(movie.getYear(), Integer.valueOf(year)))
            .count();
   }
}
