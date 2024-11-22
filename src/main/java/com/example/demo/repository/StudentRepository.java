package com.example.demo.repository;

import com.example.demo.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);
    Optional<Student> findById(Long stuId);
    Optional<Student> findByName(String name);
    List<Student> findAll();
    Optional<Student> findByStudentIdAndPassword(Long studentId,String password);
}
