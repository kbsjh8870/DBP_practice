package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts/list")
    public String listPosts(Model model) {
        List<Post> posts = new ArrayList<>();

        // 테스트 데이터
        /*Post testPost = new Post();
        testPost.setPostNumber(1L);
        testPost.setItemName("테스트 물품");
        testPost.setPrice(10000L);
        testPost.setTradingStatus("판매중");
        testPost.setDepartmentName("컴퓨터공학과");
        testPost.setCategory("전공서적");
        posts.add(testPost);

        Post testPost2 = new Post();
        testPost2.setPostNumber(2L);
        testPost2.setItemName("두번째 물품");
        testPost2.setPrice(20000L);
        testPost2.setTradingStatus("판매중");
        testPost2.setDepartmentName("컴퓨터공학과");
        testPost2.setCategory("전공서적");
        posts.add(testPost2);

        model.addAttribute("posts", posts);*/

        posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        /*System.out.println("DB에서 가져온 게시글: " + posts);*/

        return "posts/list";
    }
}

