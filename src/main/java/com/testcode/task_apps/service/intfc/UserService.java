package com.testcode.task_apps.service.intfc;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.UserDao;

import java.util.List;

public interface UserService {
    ResponseData<List<UserDao>> getAll();
}
