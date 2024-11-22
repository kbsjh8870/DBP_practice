package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("studentId") String studentId,
                        @RequestParam("password") String password,
                        Model model) {
        // TODO: 실제 로그인 로직 구현
        // 학번 중복인지 검증, DB 학생 테이블에 추가

        // 로그인 성공 시 다음페이지
        return "redirect:/";

    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam("id") Long stuId,
                                @RequestParam("password") String password) {

        /*System.out.println(name);
        System.out.println(password);*/
        Student student = new Student();
        student.setStudentId(stuId);
        student.setPassword(password);

        studentService.join(student);

        return "redirect:/";
    }
}
