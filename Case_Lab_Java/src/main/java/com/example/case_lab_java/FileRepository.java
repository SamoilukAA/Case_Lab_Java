package com.example.case_lab_java;

import java.util.ArrayList;
import java.util.Optional;

public interface FileRepository {
    Optional<FileInfo> getFileById(int id);
    void insertFile(String file_base64, String description);
    int getFileId();
}
