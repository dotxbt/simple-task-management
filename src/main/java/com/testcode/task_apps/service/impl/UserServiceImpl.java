package com.testcode.task_apps.service.impl;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.UserDao;
import com.testcode.task_apps.repository.intfc.UserRepository;
import com.testcode.task_apps.service.intfc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public ResponseData<List<UserDao>> getAll() {
        List<UserDao> data = repository.findAll();
        return ResponseData.<List<UserDao>>builder()
                .data(data).build();
    }
}
