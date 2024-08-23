package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
   private Integer page;
   @JsonProperty("per_page")
   private Integer perPage;
   private Integer total;
   @JsonProperty("total_pages")
   private Integer totalPages;
   private List<MovieData> data;

   public Integer getPage() {
      return page;
   }

   public void setPage(Integer page) {
      this.page = page;
   }

   public Integer getPerPage() {
      return perPage;
   }

   public void setPerPage(Integer perPage) {
      this.perPage = perPage;
   }

   public Integer getTotal() {
      return total;
   }

   public void setTotal(Integer total) {
      this.total = total;
   }

   public Integer getTotalPages() {
      return totalPages;
   }

   public void setTotalPages(Integer totalPages) {
      this.totalPages = totalPages;
   }

   public List<MovieData> getData() {
      return data;
   }

   public void setData(List<MovieData> data) {
      this.data = data;
   }
}