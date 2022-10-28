package com.springbootgridfsfileupload.springbootgridfsfileupload.api;

import com.springbootgridfsfileupload.springbootgridfsfileupload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/file")
public class FileUploadApi {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public void uploadFile(@RequestParam MultipartFile file) {
        fileUploadService.uploadFile(file);
    }
}
