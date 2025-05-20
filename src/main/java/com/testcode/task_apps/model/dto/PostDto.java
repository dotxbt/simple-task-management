package com.testcode.task_apps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostDto {
    private int id;
    private String userId;
    private String title;
    private String body;
}
