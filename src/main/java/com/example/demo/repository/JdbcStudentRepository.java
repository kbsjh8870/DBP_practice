package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;


public class JdbcStudentRepository implements StudentRepository{
    private final DataSource dataSource;

    public JdbcStudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Student save(Student student){
        //TODO: SQL 구문 및 연결
        String sql="";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        return student;
    }
    @Override
    public Optional<Student> findById(String stuId) {
        //TODO: SQL 구문 및 연결
        return Optional.empty();
    }

    @Override
    public Optional<Student> findByName(String name) {
        //TODO: SQL 구문 및 연결
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        //TODO: SQL 구문 및 연결
        return null;
    }
}
