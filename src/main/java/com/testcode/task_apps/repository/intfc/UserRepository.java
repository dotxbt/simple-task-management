package com.testcode.task_apps.repository.intfc;

import com.testcode.task_apps.model.dao.UserDao;

import java.util.List;

public interface UserRepository {
    List<UserDao> findAll();
    UserDao findByEmail(String email);
    UserDao create(UserDao user);
}
