package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;


public class JdbcStudentRepository implements StudentRepository{
    private final DataSource dataSource;

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

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
    public Optional<Student> findById(Long stuId) {
        String sql = "select 학번 from 학생 where 학번 = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, stuId);
            rs = pstmt.executeQuery();

            if(rs.next()) {

                System.out.println(rs.getLong(1));

                Student student = new Student();
                student.setStudentId(rs.getLong("학번"));
                return Optional.of(student);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Student> findByName(String name) {
        //TODO: SQL 구문 및 연결
        String sql="";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        //TODO: SQL 구문 및 연결
        String sql="";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        return null;
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


