package com.testcode.task_apps.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDao {
    private Integer id;
    private String title;
    private String content;
    private boolean completed;
    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;

    @JsonProperty("deleted_at")
    private Timestamp deletedAt;

    public static RowMapper<TaskDao> toRowMapper() {
        return (rs, rowNum) -> TaskDao.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .completed(rs.getBoolean("completed"))
                .build();
    }

    public static RowMapper<TaskDao> toRowMapperCreated() {
        return (rs, rowNum) -> TaskDao.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .completed(rs.getBoolean("completed"))
                .createdAt(rs.getTimestamp("created_at"))
                .build();
    }

    public static RowMapper<TaskDao> toRowMapperUpdated() {
        return (rs, rowNum) -> TaskDao.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .completed(rs.getBoolean("completed"))
                .updatedAt(rs.getTimestamp("updated_at"))
                .build();
    }
}
