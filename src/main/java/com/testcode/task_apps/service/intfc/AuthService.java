package com.testcode.task_apps.service.intfc;

import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.UserDao;
import com.testcode.task_apps.model.dto.UserDto;

public interface AuthService {
    ResponseData<UserDto> login(UserDao account);
    ResponseData<UserDao> register(UserDao account);
}
