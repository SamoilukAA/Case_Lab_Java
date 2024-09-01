package com.example.case_lab_java;

import java.time.LocalDateTime;
import java.util.Base64;

public record FileInfo(
        int id,
        String file_base64,
        LocalDateTime creation_date,
        String description
) {
}
