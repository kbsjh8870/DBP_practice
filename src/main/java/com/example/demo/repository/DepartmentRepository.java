package com.example.demo.repository;

import com.example.demo.domain.Department;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {
    private final DataSource dataSource;

    public DepartmentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Department> findAll() {
        String sql = "select 학과명, 학과번호 FROM 학과";
        List<Department> departments = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentNum(rs.getLong("학과번호"));
                department.setDepartmentName(rs.getString("학과명"));
                departments.add(department);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch departments", e);
        }

        return departments;
    }
}
