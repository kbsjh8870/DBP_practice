package com.example.demo.domain;

import java.time.LocalDateTime;

public class Student {

    private Long studentId;
    private Long departmentNum;
    private String password;
    private String name;
    private Integer postCount=0;
    private LocalDateTime joinDate=LocalDateTime.now();

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getDepartmentNum() {
        return departmentNum;
    }

    public void setDepartmentNum(Long departmentNum){
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
