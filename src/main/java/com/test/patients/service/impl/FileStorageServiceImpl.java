package com.test.patients.service.impl;

import com.test.patients.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final Logger logger = LoggerFactory.getLogger("FileStorageService");
    private final Path root = Paths.get("uploads");

    public FileStorageServiceImpl() {
        try {
            Files.createDirectory(root);
        }catch(FileAlreadyExistsException e){
            logger.warn("folder already exists");
        } catch (IOException e) {
            logger.error("couldn't created upload folder", e);
        }
    }

    @Override
    public void saveFile(MultipartFile file) {
        try {
            logger.debug("uploading file");
            Files.copy(file.getInputStream(), this.root.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        } catch (Exception e) {
            logger.error("couldn't upload file",e);
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
}
