package com.dev.demo.service.impl;

import com.dev.demo.exception.StorageException;
import com.dev.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageServiceImpl implements StorageService {


    @Value("${upload.path}")
    private String path;

    @Override
    public void uploadFile(MultipartFile file) {

        if (file.isEmpty()) throw new StorageException("Failed to store empty file");
        try {
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            Files.copy(is, Paths.get(path+fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            String msg = String.format("Failed to store file %f", file.getName());
            throw new StorageException(msg, e);
        }
    }
}
