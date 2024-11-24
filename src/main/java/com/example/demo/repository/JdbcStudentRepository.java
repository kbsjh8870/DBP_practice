package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
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

    @Override // 회원가입 정보 db 저장
    public Student save(Student student){
        String sql = "insert into 학생 values(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, student.getStudentId());
            pstmt.setLong(2, student.getDepartmentNum());
            pstmt.setString(3, student.getPassword());
            pstmt.setString(4, student.getName());
            pstmt.setLong(5, 0);

            LocalDateTime joinDate = student.getJoinDate();
            java.sql.Date sqlDate = java.sql.Date.valueOf(joinDate.toLocalDate());
            pstmt.setDate(6, sqlDate);

            pstmt.executeUpdate();

            return student;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }
    @Override // 학번으로 학생 검색
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

    @Override // 이름으로 학생 검색
    public Optional<Student> findByName(String name) {
        //TODO: SQL 구문 및 연결
        String sql="";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        return Optional.empty();
    }

    @Override // 모든 학생 검색
    public List<Student> findAll() {
        //TODO: SQL 구문 및 연결
        String sql="";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        return null;
    }

    @Override
    public Optional<Student> findByStudentIdAndPassword(Long studentId, String password) {
        String sql = "SELECT 학번, 비밀번호 FROM 학생 WHERE 학번 = ? AND 비밀번호 = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, studentId);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getLong("학번")); // 학번이 숫자라면 Long으로 사용

                return Optional.of(student);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs); // 자원 해제
        }
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


