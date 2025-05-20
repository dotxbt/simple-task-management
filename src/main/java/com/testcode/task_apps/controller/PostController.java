package com.testcode.task_apps.controller;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dto.PostDto;
import com.testcode.task_apps.service.intfc.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public ResponseData<List<PostDto>> getPosts() {
        return postService.getPosts();
    }
}
