package com.example.case_lab_java;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/files")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/{fileId:\\d+}")
    public FileInfo getFile(@PathVariable int fileId) {
        return fileService.getFile(fileId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdFile createFile(@Valid @RequestBody FileRequest request) {
        fileService.createFile(
                request.file_base64(),
                request.description()
        );
        int id = fileService.getID();
        return new IdFile(id);
    }
}
