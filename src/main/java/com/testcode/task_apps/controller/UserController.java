package com.testcode.task_apps.controller;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.UserDao;
import com.testcode.task_apps.service.intfc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseData<List<UserDao>> getAll() {
        return service.getAll();
    }
}
