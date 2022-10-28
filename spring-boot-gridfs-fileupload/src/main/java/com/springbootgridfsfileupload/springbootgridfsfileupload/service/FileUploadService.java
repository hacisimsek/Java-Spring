package com.springbootgridfsfileupload.springbootgridfsfileupload.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    public void uploadFile(MultipartFile file) {
        try {
            DBObject metaData = new BasicDBObject();
            metaData.put("filename", file.getOriginalFilename());
            metaData.put("contentType", file.getContentType());
            metaData.put("size", file.getSize());
            metaData.put("userId", "123");
            ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData);
            System.out.println("File uploaded successfully " + id.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
