package com.example.case_lab_java;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileMapper implements RowMapper<FileInfo> {
    @Override
    public FileInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSSSSS]";
        String date = rs.getString("creation_date");
        LocalDateTime creation_date = LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
        return new FileInfo(
                rs.getInt("id"),
                rs.getString("file_base64"),
                creation_date,
                rs.getString("description")
        );
    }
}
