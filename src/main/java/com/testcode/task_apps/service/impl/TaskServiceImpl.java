package com.testcode.task_apps.service.impl;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.TaskDao;
import com.testcode.task_apps.model.dto.TaskDto;
import com.testcode.task_apps.repository.intfc.TaskRepository;
import com.testcode.task_apps.service.intfc.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository repository;

    @Override
    public ResponseData<List<TaskDao>> findAll(@Nullable String complete) {
        return ResponseData.<List<TaskDao>>builder()
                .data(repository.findAll(complete))
                .message("Success get all data").build();
    }

    @Override
    public ResponseData<TaskDao> create(TaskDto task) {
        return ResponseData.<TaskDao>builder()
                .data(repository.create(task)).build();
    }

    @Override
    public ResponseData<TaskDao> update(TaskDto task) {
        return ResponseData.<TaskDao>builder()
                .data(repository.update(task))
                .message("OK").build();
    }

    @Override
    public ResponseData<TaskDao> delete(Integer id) {
        return ResponseData.<TaskDao>builder()
                .data(repository.delete(id)).build();
    }
}
