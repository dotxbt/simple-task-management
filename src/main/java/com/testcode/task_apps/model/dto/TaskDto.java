package com.testcode.task_apps.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.testcode.task_apps.model.dao.TaskDao;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskDto extends TaskDao {
    @JsonProperty("user_id")
    private Integer userId;
}
