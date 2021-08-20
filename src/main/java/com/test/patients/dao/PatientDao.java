package com.test.patients.dao;

import com.test.patients.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientDao extends CrudRepository<Patient, UUID> {
}
