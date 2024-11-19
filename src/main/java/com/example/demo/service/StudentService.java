package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    private void vaildateDuplicateStudent(Student student) {

      /* StudentRepository.findByName(Student.getName())
                .ifPresent(m->{ // ifPresent: 값이 존재한다면
                    throw new IllegalStateException("이미 존재하는 학생");
                });*/
    }

    public String join(Student student){

        /*vaildateDuplicateStudent();*/
        return student.getStudentId();
    }
}
