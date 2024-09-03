package com.example.demo.entity;

import com.example.demo.entity.Teacher;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @ManyToMany(mappedBy = "students")
   private Set<Teacher> teachers = new HashSet<>();

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Set<Teacher> getTeachers() {
      return teachers;
   }

   public void setTeachers(Set<Teacher> teachers) {
      this.teachers = teachers;
   }
}
