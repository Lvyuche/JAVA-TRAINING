package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

   private final TeacherService teacherService;

   public TeacherController(TeacherService teacherService) {
      this.teacherService = teacherService;
   }

   @PostMapping
   public ResponseEntity<Teacher> create(@RequestBody Teacher teacher) {
      Teacher savedTeacher = teacherService.save(teacher);
      return ResponseEntity.ok(savedTeacher);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Teacher> read(@PathVariable Long id) {
      Teacher teacher = teacherService.findById(id);
      if (teacher != null) {
         return ResponseEntity.ok(teacher);
      } else {
         return ResponseEntity.notFound().build();
      }
   }

   @PutMapping("/{id}")
   public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacher) {
      teacher.setId(id);
      Teacher updatedTeacher = teacherService.update(teacher);
      return ResponseEntity.ok(updatedTeacher);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {
      teacherService.delete(id);
      return ResponseEntity.noContent().build();
   }

   @GetMapping
   public ResponseEntity<List<Teacher>> getAllTeachers() {
      List<Teacher> teachers = teacherService.findAll();
      return ResponseEntity.ok(teachers);
   }
}
