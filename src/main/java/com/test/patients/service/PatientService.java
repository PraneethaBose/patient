package com.test.patients.service;

import com.test.patients.dto.PatientDTO;
import com.test.patients.dto.PatientResponseDTO;

public interface PatientService {
    PatientResponseDTO save(PatientDTO patient);
}
