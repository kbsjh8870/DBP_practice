package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByKeyword(keyword);
    }

    public Long createPost(Post post) {
        postRepository.save(post);
        return post.getPostNumber();
    }

    public void updatePost(Post post) {
        // 게시글 존재 여부 확인
        Post existingPost = postRepository.findById(post.getPostNumber())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 게시글입니다."));

        postRepository.update(post);
    }

    public Optional<Post> getPost(Long postNumber) {
        return postRepository.findById(postNumber);
    }

    public void deletePost(Long postNumber) {
        // 게시글 존재 여부 확인
        Post post = postRepository.findById(postNumber)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 게시글입니다."));

        postRepository.delete(postNumber);
    }
}