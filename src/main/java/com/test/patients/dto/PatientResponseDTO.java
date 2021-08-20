package com.test.patients.dto;

import java.util.UUID;

public class PatientResponseDTO extends PatientDTO{
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
