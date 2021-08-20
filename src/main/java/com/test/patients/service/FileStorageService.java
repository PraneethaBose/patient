package com.test.patients.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void saveFile(MultipartFile file);
}
