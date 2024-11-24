package com.example.demo.service;

import com.example.demo.domain.Department;
import com.example.demo.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
