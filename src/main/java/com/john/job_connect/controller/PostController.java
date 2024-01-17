package com.john.job_connect.controller;

import com.john.job_connect.model.Post;
import com.john.job_connect.repository.PostRepository;
import com.john.job_connect.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")

public class PostController {
    private final PostRepository postRepository;
    private final SearchRepository searchRepository;
    @GetMapping("/posts")
    public List<Post> getAllPosts(){

      return postRepository.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> searchItem(@PathVariable String text){
        return searchRepository.findByText(text);
    }

    @PostMapping("/post")
    public Post createPost(@RequestBody Post post){
      return postRepository.save(post);
    }
}
