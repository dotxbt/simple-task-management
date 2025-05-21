package com.testcode.task_apps.controller;

import com.testcode.task_apps.helper.EnvResource;
import com.testcode.task_apps.model.ResponseData;
import com.testcode.task_apps.model.dao.UserDao;
import com.testcode.task_apps.model.dto.UserDto;
import com.testcode.task_apps.service.intfc.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public ResponseData<UserDto> login(@RequestBody UserDao user, HttpServletResponse response) {
        ResponseData<UserDto> res = service.login(user);

        int maxAge = Integer.parseInt(new EnvResource().get("env.max.age.token"));
        Cookie cookie = new Cookie("_csrf_token", res.getData().getToken());
        cookie.setMaxAge(maxAge);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);

        Cookie cookieRefresh = new Cookie("_csrf_rf_token", res.getData().getRefreshToken());
        cookieRefresh.setMaxAge(maxAge * 30);
        cookieRefresh.setSecure(true);
        cookieRefresh.setHttpOnly(true);

        response.addCookie(cookie);
        response.addCookie(cookieRefresh);

        return res;
    }

    @PostMapping("/register")
    public ResponseData<UserDao> register(@RequestBody UserDao user) {
        return service.register(user);
    }
}
