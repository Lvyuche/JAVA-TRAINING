package com.example.demo.service;

import com.example.demo.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

   @PersistenceContext
   private EntityManager entityManager;

   @Transactional
   public Teacher save(Teacher teacher) {
      entityManager.persist(teacher);
      return teacher;
   }

   public Teacher findById(Long id) {
      return entityManager.find(Teacher.class, id);
   }

   @Transactional
   public Teacher update(Teacher teacher) {
      return entityManager.merge(teacher);
   }

   @Transactional
   public void delete(Long id) {
      Teacher teacher = findById(id);
      if (teacher != null) {
         entityManager.remove(teacher);
      }
   }

   public List<Teacher> findAll() {
      return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
   }
}