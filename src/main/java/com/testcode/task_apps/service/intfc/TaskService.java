package com.testcode.task_apps.service.intfc;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.TaskDao;
import com.testcode.task_apps.model.dto.TaskDto;
import org.springframework.lang.Nullable;

import java.util.List;

public interface TaskService {
    ResponseData<List<TaskDao>> findAll(@Nullable String complete);
    ResponseData<TaskDao> create(TaskDto task);
    ResponseData<TaskDao> update(TaskDto task);
    ResponseData<TaskDao> delete(Integer id);
}