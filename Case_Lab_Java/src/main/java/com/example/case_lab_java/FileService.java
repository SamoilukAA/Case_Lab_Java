package com.example.case_lab_java;

import java.sql.Date;
import java.util.ArrayList;

public interface FileService {
    FileInfo getFile(int fileId);
    void createFile(String file_base64, String description);
    int getID();
}
