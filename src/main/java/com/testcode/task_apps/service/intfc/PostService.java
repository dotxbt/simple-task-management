package com.testcode.task_apps.service.intfc;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dto.PostDto;

import java.util.List;

public interface PostService {
    ResponseData<List<PostDto>> getPosts();
}
