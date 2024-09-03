package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   public Student save(Student student) {
      entityManager.persist(student);
      return student;
   }

   public Student findById(Long id) {
      return entityManager.find(Student.class, id);
   }

   @Transactional
   public Student update(Student student) {
      return entityManager.merge(student);
   }

   @Transactional
   public void delete(Long id) {
      Student student = findById(id);
      if (student != null) {
         entityManager.remove(student);
      }
   }

   @Transactional
   public void addTeacherToStudent(Long studentId, Long teacherId) {
      Student student = findById(studentId);
      Teacher teacher = entityManager.find(Teacher.class, teacherId);

      if (student != null && teacher != null) {
         student.getTeachers().add(teacher);
         teacher.getStudents().add(student);
         entityManager.merge(student);
         entityManager.merge(teacher);
      }
   }

   public List<Student> findStudentsWithTeachers() {
      CriteriaBuilder cb = entityManager.getCriteriaBuilder();
      CriteriaQuery<Student> cq = cb.createQuery(Student.class);
      Root<Student> student = cq.from(Student.class);

      Join<Student, Teacher> teacher = student.join("teachers");

      cq.select(student).distinct(true).where(cb.gt(student.get("id"), 10));

      TypedQuery<Student> query = entityManager.createQuery(cq);
      return query.getResultList();
   }
}