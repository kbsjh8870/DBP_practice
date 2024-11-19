package com.example.demo.domain;

import java.time.LocalDateTime;

public class Student {

    private String studentId;
    private String departmentNum;
    private String password;
    private String name;
    private Integer postCount;
    private LocalDateTime joinDate;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDepartmentNum() {
        return departmentNum;
    }

    public void setDepartmentNum(String departmentNum){
        this.departmentNum = departmentNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }
}
