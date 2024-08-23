package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class University {
   private String country;
   private List<String> domains;
   @JsonProperty("state-province")
   private String stateProvince;
   @JsonProperty("web_pages")
   private List<String> webPages;
   private String name;
   @JsonProperty("alpha_two_code")
   private String alphaTwoCode;
   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public List<String> getDomains() {
      return domains;
   }

   public void setDomains(List<String> domains) {
      this.domains = domains;
   }

   public String getStateProvince() {
      return stateProvince;
   }

   public void setStateProvince(String stateProvince) {
      this.stateProvince = stateProvince;
   }

   public List<String> getWebPages() {
      return webPages;
   }

   public void setWebPages(List<String> webPages) {
      this.webPages = webPages;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAlphaTwoCode() {
      return alphaTwoCode;
   }

   public void setAlphaTwoCode(String alphaTwoCode) {
      this.alphaTwoCode = alphaTwoCode;
   }
}
