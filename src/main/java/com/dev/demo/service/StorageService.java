package com.dev.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void uploadFile(MultipartFile file);
}
