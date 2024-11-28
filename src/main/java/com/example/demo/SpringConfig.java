package com.example.demo;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.JdbcStudentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.PostService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public DepartmentService departmentService(){
        return new DepartmentService(departmentRepository());
    }
    @Bean
    public DepartmentRepository departmentRepository(){
        return new DepartmentRepository(dataSource);
    }
    @Bean
    public StudentService studentService(){
        return new StudentService(studentRepository());
    }

    @Bean
    public StudentRepository studentRepository(){
        return new JdbcStudentRepository(dataSource);
    }

    @Bean
    public PostService postService(){
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository(){
        return new PostRepository(dataSource);
    }
}
