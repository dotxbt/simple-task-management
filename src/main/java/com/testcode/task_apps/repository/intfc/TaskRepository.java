package com.testcode.task_apps.repository.intfc;

import com.testcode.task_apps.model.dao.TaskDao;
import com.testcode.task_apps.model.dto.TaskDto;
import org.springframework.lang.Nullable;

import java.util.List;

public interface TaskRepository {
    List<TaskDao> findAll(@Nullable String complete);
    TaskDao create(TaskDto task);
    TaskDao update(TaskDto task);
    TaskDao delete(Integer id);
}
