package com.testcode.task_apps.service.impl;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dto.PostDto;
import com.testcode.task_apps.service.intfc.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    WebClient client;

    @Override
    public ResponseData<List<PostDto>> getPosts() {
        List<PostDto> data = client.get().uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();
        return ResponseData.<List<PostDto>>builder()
                .data(data).build();
    }
}
