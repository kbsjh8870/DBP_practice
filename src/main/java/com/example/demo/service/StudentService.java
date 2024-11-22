package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    private void vaildateDuplicateStudent(Student student) {

       studentRepository.findById(student.getStudentId())
                .ifPresent(m->{ // ifPresent: 값이 존재한다면
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }

    public Long join(Student student){

        vaildateDuplicateStudent(student);
        studentRepository.save(student);

        return student.getStudentId();
    }

    public Optional<Student> login(Long studentId, String password) {
        return studentRepository.findByStudentIdAndPassword(studentId, password);
    }
}
