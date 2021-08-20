package com.test.patients.service.impl;

import com.test.patients.dao.PatientDao;
import com.test.patients.dto.PatientDTO;
import com.test.patients.dto.PatientResponseDTO;
import com.test.patients.mappers.PatientMapper;
import com.test.patients.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;
    private final PatientDao patientDao;

    public PatientServiceImpl(PatientMapper patientMapper, PatientDao patientDao) {
        this.patientMapper = patientMapper;
        this.patientDao = patientDao;
    }

    @Override
    public PatientResponseDTO save(PatientDTO patient) {
        return patientMapper.patientToPatientDTO(patientDao.save(patientMapper.patientDtoTOPatient(patient)));
    }
}
