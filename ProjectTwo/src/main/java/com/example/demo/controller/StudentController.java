package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;

   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }

   @PostMapping
   public ResponseEntity<Student> create(@RequestBody Student student) {
      Student savedStudent = studentService.save(student);
      return ResponseEntity.ok(savedStudent);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Student> read(@PathVariable Long id) {
      Student student = studentService.findById(id);
      if (student != null) {
         return ResponseEntity.ok(student);
      } else {
         return ResponseEntity.notFound().build();
      }
   }

   @PutMapping("/{id}")
   public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
      student.setId(id);
      Student updatedStudent = studentService.update(student);
      return ResponseEntity.ok(updatedStudent);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {
      studentService.delete(id);
      return ResponseEntity.noContent().build();
   }

   @PostMapping("/{studentId}/teachers/{teacherId}")
   public ResponseEntity<Void> addTeacherToStudent(@PathVariable Long studentId, @PathVariable Long teacherId) {
      studentService.addTeacherToStudent(studentId, teacherId);
      return ResponseEntity.ok().build();
   }

   @GetMapping("/with-teachers")
   public ResponseEntity<List<Student>> getStudentsWithTeachers() {
      List<Student> students = studentService.findStudentsWithTeachers();
      return ResponseEntity.ok(students);
   }
}