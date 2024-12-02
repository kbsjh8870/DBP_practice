package com.example.demo.controller;

import com.example.demo.domain.Department;
import com.example.demo.domain.Student;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final DepartmentService departmentService;

    @Autowired
    public StudentController(StudentService studentService, DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("studentId") Long studentId,
                        @RequestParam("password") String password,
                        Model model) {

        Optional<Student> optionalStudent = studentService.login(studentId, password);

        if (optionalStudent.isPresent()) {
            // 로그인 성공
            model.addAttribute("student", optionalStudent.get()); // 로그인한 학생 정보 전달
            return "redirect:/posts/list";
        } else {
            // 로그인 실패
            model.addAttribute("error", "Invalid student ID or password");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments", departments);
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam("id") Long stuId,
                                @RequestParam("password") String password,
                                @RequestParam("name") String name,
                                @RequestParam("departmentNum") Long departmentNum) {
        /*System.out.println(name);
        System.out.println(password);*/
        Student student = new Student();
        student.setStudentId(stuId);
        student.setPassword(password);
        student.setName(name);
        student.setDepartmentNum(departmentNum);

        studentService.join(student);

        return "redirect:/";
    }
}
