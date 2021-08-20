package com.test.patients.mappers;

import com.test.patients.dto.PatientDTO;
import com.test.patients.dto.PatientResponseDTO;
import com.test.patients.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    private final ModelMapper modelmapper;

    public PatientMapper(ModelMapper modelmapper) {
        this.modelmapper = modelmapper;
    }

    public Patient patientDtoTOPatient(PatientDTO patientDTO){
        return modelmapper.map(patientDTO,Patient.class);
    }

    public PatientResponseDTO patientToPatientDTO(Patient patient){
        return modelmapper.map(patient,PatientResponseDTO.class);
    }
}
