package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @ManyToMany
   @JoinTable(
         name = "student_teacher",
         joinColumns = @JoinColumn(name = "teacher_id"),
         inverseJoinColumns = @JoinColumn(name = "student_id"))
   private Set<Student> students = new HashSet<>();

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

   public Set<Student> getStudents() {
      return students;
   }

   public void setStudents(Set<Student> students) {
      this.students = students;
   }
}

