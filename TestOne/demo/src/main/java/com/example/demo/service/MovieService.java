package com.example.demo.service;

import com.example.demo.model.ResponseDTO;
import org.springframework.stereotype.Service;

public interface MovieService {
   ResponseDTO getMoviesByYear(String year);
}
