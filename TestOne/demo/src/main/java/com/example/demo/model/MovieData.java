package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieData {

   @JsonProperty("Title")
   private String title;

   @JsonProperty("Year")
   private Integer year;

   @JsonProperty("imdbID")
   private String imdbID;

   // Getters and Setters
   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public String getImdbID() {
      return imdbID;
   }

   public void setImdbID(String imdbID) {
      this.imdbID = imdbID;
   }
}
