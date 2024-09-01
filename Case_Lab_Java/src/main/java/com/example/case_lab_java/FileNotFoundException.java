package com.example.case_lab_java;

public class FileNotFoundException extends RuntimeException {
    private final int fileId;

    public FileNotFoundException(int fileId) {
      this.fileId = fileId;
    }

    @Override
    public String getMessage() {
      return "File with id = " + fileId + " not found";
    }
}
