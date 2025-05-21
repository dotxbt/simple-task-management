package com.testcode.task_apps.repository.impl;

import com.testcode.task_apps.configuration.ErrorHandlerException;
import com.testcode.task_apps.model.ErrorMessage;
import com.testcode.task_apps.model.dao.UserDao;
import com.testcode.task_apps.repository.intfc.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    JdbcTemplate db;


    @Override
    public List<UserDao> findAll() {
        return db.query("SELECT * FROM users", UserDao.toFindAllRowMapper());
    }

    @Override
    public UserDao findByEmail(String email) {
        try {
            return db.queryForObject("SELECT * FROM users WHERE email=?", UserDao.toRowMapper(), email);
        } catch (Exception e) {
            throw new ErrorHandlerException(ErrorMessage.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Username tidak ditemukan")
                    .build());
        }
    }

    @Override
    public UserDao create(UserDao user) {
        try {
            return db.queryForObject("INSERT INTO users (email, password, role) VALUES (?,?,?) RETURNING *",
                    UserDao.toRowMapper(),
                    user.getEmail(), user.getPassword(),
                    user.getRole());
        } catch (Exception e) {
            throw new ErrorHandlerException(ErrorMessage.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Username sudah tersedia" + e.getMessage())
                    .build());
        }
    }
}
