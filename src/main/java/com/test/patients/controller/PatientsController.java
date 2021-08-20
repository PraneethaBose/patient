package com.test.patients.controller;

import com.test.patients.dto.PatientDTO;
import com.test.patients.dto.RootResponseDTO;
import com.test.patients.service.FileStorageService;
import com.test.patients.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PatientsController {

    private final PatientService patientService;
    private final FileStorageService fileStorageService;

    public PatientsController(PatientService patientService, FileStorageService fileStorageService, FileStorageService fileStorageService1) {
        this.patientService = patientService;
        this.fileStorageService = fileStorageService1;
    }

    @PostMapping("/patient")
    public ResponseEntity<RootResponseDTO> createPatient(@RequestBody PatientDTO patientDTO) throws Exception {
        return ResponseEntity.ok(new RootResponseDTO(true, patientService.save(patientDTO)));
    }


    @PostMapping("/datapoint")
    public ResponseEntity<RootResponseDTO> datapointUpload(@RequestParam("file") MultipartFile file) {
        fileStorageService.saveFile(file);
        return ResponseEntity.ok(new RootResponseDTO(true,"file uploaded"));
    }


}
