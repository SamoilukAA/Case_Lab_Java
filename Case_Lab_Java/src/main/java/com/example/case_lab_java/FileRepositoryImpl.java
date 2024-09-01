package com.example.case_lab_java;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public class FileRepositoryImpl implements FileRepository {
    private static final String SQL_GET_FILE_BY_ID =
            "select * from files_info where id = :id";
    private static final String SQL_INSERT_FILE =
            "insert into files_info (file_base64, creation_date, description) values (:file_base64, :creation_date, :description)";

    private static final String SQL_GET_FILE_ID =
            "select * from files_info ORDER BY id DESC LIMIT 1";

    private static final String SQL_GET_ALL_FILES =
            "select * from files_info";

    private final FileMapper fileMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public FileRepositoryImpl(
            FileMapper fileMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.fileMapper = fileMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<FileInfo> getFileById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(
                        SQL_GET_FILE_BY_ID,
                        params,
                        fileMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void insertFile(String file_base64, String description) {
        String creation_date = LocalDateTime.now().toString();
        var params = new MapSqlParameterSource();
        params.addValue("file_base64", file_base64);
        params.addValue("creation_date", creation_date);
        params.addValue("description", description);
        jdbcTemplate.update(SQL_INSERT_FILE, params);
    }

    @Override
    public int getFileId() {
        Optional<FileInfo> fileInfo = jdbcTemplate.query(
                        SQL_GET_FILE_ID,
                        fileMapper
                ).stream()
                .findFirst();
        int id = 0;
        if (fileInfo.isPresent()) {
            id = fileInfo.get().id();
        }
        return id;
    }
}
