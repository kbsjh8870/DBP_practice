package com.example.demo.controller;

import com.example.demo.service.StudentService;
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
        // 예: 사용자 인증, 세션 처리 등

        // 로그인 성공 시
        return "redirect:/dashboard";

        // 로그인 실패 시
        // model.addAttribute("error", "Invalid credentials");
        // return "login";
    }
}
