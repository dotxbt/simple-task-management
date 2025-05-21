package com.testcode.task_apps.controller;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.TaskDao;
import com.testcode.task_apps.model.dto.TaskDto;
import com.testcode.task_apps.service.intfc.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService service;

    @GetMapping()
    public ResponseData<List<TaskDao>> getAllTask(@Nullable @RequestParam(value = "complete") String complete ) {
        return service.findAll(complete);
    }

    @PostMapping()
    public ResponseData<TaskDao> create(@RequestBody TaskDto task) {
        return service.create(task);
    }

    @PutMapping()
    public ResponseData<TaskDao> update(@RequestBody TaskDto task) {
        return service.update(task);
    }

    @DeleteMapping("/{id}")
    public ResponseData<TaskDao> delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
}
