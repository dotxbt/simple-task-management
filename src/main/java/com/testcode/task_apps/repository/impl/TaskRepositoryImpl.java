package com.testcode.task_apps.repository.impl;

import com.testcode.task_apps.configuration.ErrorHandlerException;
import com.testcode.task_apps.model.ErrorMessage;
import com.testcode.task_apps.model.dao.TaskDao;
import com.testcode.task_apps.model.dto.TaskDto;
import com.testcode.task_apps.repository.intfc.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Autowired
    JdbcTemplate db;

    @Override
    public List<TaskDao> findAll(@Nullable String complete) {
        String filter = "";
        if (complete != null) {
            filter = " WHERE completed=" + complete;
        }
        return db.query("SELECT * from task" + filter, TaskDao.toRowMapper());
    }

    @Override
    public TaskDao create(TaskDto task) {
        try {
            return db.queryForObject("INSERT INTO task (title, content, user_id) VALUES (?,?,?) RETURNING *", TaskDao.toRowMapperCreated(),
                    task.getTitle(), task.getContent(), task.getUserId());
        } catch (Exception e) {
            throw new ErrorHandlerException(ErrorMessage.builder()
                    .status(HttpStatus.BAD_REQUEST).message("Update Failed!").build());
        }
    }

    @Override
    public TaskDao update(TaskDto task) {
        try {
            return db.queryForObject("UPDATE task SET title=COALESCE(?, title), content=COALESCE(?, content), completed=COALESCE(?, completed), user_id=COALESCE(?, user_id), updated_at=? WHERE id=? RETURNING *",
                    TaskDao.toRowMapperUpdated(),
                    task.getTitle(), task.getContent(),
                    task.isCompleted(),
                    task.getUserId(),
                    Timestamp.from(Instant.now()),
                    task.getId()
            );
        } catch (Exception e) {
            throw new ErrorHandlerException(ErrorMessage.builder()
                    .status(HttpStatus.BAD_REQUEST).message("Update data failed!").build());
        }
    }

    @Override
    public TaskDao delete(Integer id) {
        try {
            return db.queryForObject("DELETE FROM task WHERE id=? RETURNING *",
                    TaskDao.toRowMapper(),
                    id);
        } catch (Exception e) {
            throw new ErrorHandlerException(ErrorMessage.builder()
                    .status(HttpStatus.BAD_REQUEST).message("Id not found!").build());
        }
    }
}
