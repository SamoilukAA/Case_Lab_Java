package com.example.case_lab_java;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public FileInfo getFile(int personId) {
        return fileRepository.getFileById(personId)
                .orElseThrow(() -> new FileNotFoundException(personId));
    }

    @Override
    public void createFile(String file_base64, String description) {
        fileRepository.insertFile(file_base64, description);
    }

    @Override
    public int getID() {
        return fileRepository.getFileId();
    }
}
